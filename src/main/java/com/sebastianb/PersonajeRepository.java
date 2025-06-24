package com.sebastianb;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class PersonajeRepository {

    private final Map<Long, Personaje> personajes = new HashMap<>();

    // Agrega uno o varios personajes y los retorna en una lista
    public List<Personaje> agregar(Personaje... nuevos) {
        List<Personaje> agregados = new ArrayList<>();
        for (Personaje p : nuevos) {
            if (p.getId() == null) {
                p.setId(generarId());
            }
            personajes.put(p.getId(), p);
            agregados.add(p);
        }
        return agregados;
    }

    // Edita un personaje por id usando un DTO (debes crear PersonajeUpdateDTO)
    public void editarPorId(long id, PersonajeUpdateDTO dto) {
        Personaje p = personajes.get(id);
        if (p != null) {
            if (dto.getNombre() != null) p.setNombre(dto.getNombre());
            if (dto.getSaludMaxima() != null) p.setSaludMaxima(dto.getSaludMaxima());
            if (dto.getNivelDePoder() != null) p.setNivelDePoder(dto.getNivelDePoder());
            if (dto.getListaDePoderes() != null) p.setListaDePoderes(new ArrayList<>(dto.getListaDePoderes()));
        }
    }

    // Elimina un personaje por id
    public void delPersonajeById(long id) {
        personajes.remove(id);
    }

    // Retorna todos los personajes como lista
    public List<Personaje> listar() {
        return new ArrayList<>(personajes.values());
    }

    // Obtiene un personaje por id
    public Personaje getPersonajeById(long id) {
        return personajes.get(id);
    }

    // Devuelve el mapa completo (para test)
    public Map<Long, Personaje> getPersonajes() {
        return personajes;
    }

    // Genera un id único (si el personaje no lo trae)
    private static final AtomicLong idGen = new AtomicLong(1);
    private long generarId() {
        return idGen.getAndIncrement();
    }
}

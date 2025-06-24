package com.sebastianb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;

public class PersonajeRepositoryTest {

    @Test
    public void editarPersonajePorId() {
        PersonajeRepository personajeRepository = new PersonajeRepository();
        PersonajeUpdateDTO dto = new PersonajeUpdateDTO();
        Personaje p1 = new Personaje("Kitana", 90, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        personajeRepository.agregar(p1);
        personajeRepository.editarPorId(1, dto);

        String comprobacion = "Personaje: Kitana, Vida: 90, Poder: ALTO, Poderes: [Mighty Punch, Cabezas voladoras]";
        assertEquals(comprobacion, personajeRepository.getPersonajeById(1).toString());
    }

    @Test
    public void agregarPersonajes() {
        PersonajeRepository personajeRepository = new PersonajeRepository();

        Personaje p1 = new Personaje("Mario Bros", 100, Poder.ALTO, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, Poder.BAJO, List.of("Noo", "Boo", "Pizza"));
        assertNotNull(personajeRepository.agregar(p1, p2)); // Esto es porque quiero que al agregar devuelva lo recién
                                                            // agregado
    }

    @Test
    public void eliminarPersonajePorId() {
        PersonajeRepository personajeRepository = new PersonajeRepository();

        Personaje p1 = new Personaje("Mario Bros", 100, Poder.ALTO, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, Poder.BAJO, List.of("Noo", "Boo", "Pizza"));
        personajeRepository.agregar(p1, p2);

        // Eliminar el personaje con id 2
        personajeRepository.delPersonajeById(2);

        // Comprobar que el personaje con id 2 ya no existe
        assertNull(personajeRepository.getPersonajeById(2));
        // Comprobar que el personaje con id 1 sigue existiendo
        assertNotNull(personajeRepository.getPersonajeById(1));
        // Comprobar que solo queda un personaje en el repositorio
        assertEquals(1, personajeRepository.getPersonajes().size());
    }

    @Test
    public void listarPersonajes() {
        // Aquí irá la lógica para conseguir crear un repositorio de personajes de MK.
        PersonajeRepository personajeRepository = new PersonajeRepository();
        Personaje p1 = new Personaje("Mario Bros", 100, Poder.ALTO, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, Poder.BAJO, List.of("Noo", "Boo", "Pizza"));
        List<Personaje> comprobar = List.of(p1, p2);
        personajeRepository.agregar(p1, p2);

        assertEquals(comprobar, personajeRepository.listar());
    }
}

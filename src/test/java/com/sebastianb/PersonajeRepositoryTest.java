package com.sebastianb;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;
public class PersonajeRepositoryTest {

    
    @Test
    public void editarPersonajePorId(){
        private PersonajeRepository personajeRepository = new PersonajeRepository();
        //Aqui iría la lógica junto al método utilizado para poder editar un personaje por id
        Personaje personajeEditado = new Personaje();
        PersonajeUpdateDTO dto = new PersonajeUpdateDTO();

        dto.setNombre("KitanaEditada");

        personajeRepository.editarPorId(1,dto);

        String comprobacion = "Personaje: Kitana, Vida: 90, Poder: MEDIO, Poderes: [Fan Throw]";
        assertEquals(comprobacion, personajeRepository.getPersonajeById(1).toString());
    }

    @Test
    public void agregarPersonajes(){
        PersonajeRepository personajeRepository = new PersonajeRepository();

        Personaje p1 = new Personaje("Mario Bros", 100, poder.FUERTE, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, poder.DEBIL, List.of("Noo", "Boo", "Pizza"));
        assertNotNull(personajeRepository.agregar(p1, p2)); //Esto es porque quiero que al agregar devuelva lo recién agregado
    }

    @Test
    public void eliminarPersonajePorId(){
       PersonajeRepository personajeRepository = new PersonajeRepository();

        Personaje p1 = new Personaje("Mario Bros", 100, poder.FUERTE, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, poder.DEBIL, List.of("Noo", "Boo", "Pizza"));
        personajeRepository.delPersonajeById(2);
        assertThat(personajeRepository.getPersonajes().size(), Matchers.lessThan(2));
    }

    @Test
    public void listarPersonajes(){
        // Aquí irá la lógica para conseguir crear un repositorio de personajes de MK.
        PersonajeRepository personajeRepository = new PersonajeRepository();
        Personaje p1 = new Personaje("Mario Bros", 100, poder.FUERTE, List.of("Yahoo", "Wahoo", "Mamma Mia"));
        Personaje p2 = new Personaje("Luigi", 95, poder.DEBIL, List.of("Noo", "Boo", "Pizza"));
        List<Personaje> comprobar = List.of(p1,p2);
        personajeRepository.agregar(p1,p2);

        assertArrayEquals(comprobar, personajeRepository.listar());
    }
}

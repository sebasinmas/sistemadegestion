package com.sebastianb;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.*;

public class PersonajeTest {
    
    @Test
    public void crearPersonaje(){
        Personaje personaje = new Personaje("Scorpion", 100, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        assertNotNull(personaje);
    }

    @Test
    public void crearPersonajeConPoderes(){
        Personaje personaje = new Personaje("Sub-Zero", 120, Poder.MEDIO, List.of("Mighty Punch", "Cabezas voladoras"));
        personaje.agregarPoder("Ice Blast");

        assertArrayEquals(List.of("Mighty Punch", "Cabezas voladoras", "Ice Blast") ,personaje.getListaDePoderes());
    }
    @Test
    public void agregarPoderAlPersonaje(){
        Personaje personaje = new Personaje("Liu Kang", 110, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        personaje.agregarPoder("Dragon Kick");
        personaje.eliminarPoder("Dragon Kick");
        assertNotEquals(personaje.getListaDePoderes().size(), 1);
    }

    @Test
    public void eliminarPoderDePersonaje(){
        Personaje personaje = new Personaje("Liu Kang", 110, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        personaje.agregarPoder("Dragon Kick");
        personaje.eliminarPoder("Dragon Kick");
        assert !personaje.getListaDePoderes().contains("Dragon Kick");
    }

    @Test
    public void listarPoderesDePersonaje(){
        Personaje personaje = new Personaje("Raiden", 130, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        personaje.agregarPoder("Thunder Strike");
        personaje.agregarPoder("Lightning Bolt");
        assert personaje.getListaDePoderes().size() == 2;
        assert personaje.getListaDePoderes().contains("Thunder Strike");
        assert personaje.getListaDePoderes().contains("Lightning Bolt");
    }

    @Test
    public void personajeToString() {
        Personaje personaje = new Personaje("Kitana", 90, Poder.ALTO, List.of("Mighty Punch", "Cabezas voladoras"));
        personaje.agregarPoder("Fan Throw");
        String expected = "Personaje: Kitana, Vida: 90, Poder: MEDIO, Poderes: [Fan Throw]";
        assert personaje.toString().equals(expected);
    }
}

package com.sebastianb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {
    private static final AtomicLong contador = new AtomicLong(1);

    private Long id;  //(generado automáticamente)
    private String nombre;
    private int saludMaxima;
    private Poder nivelDePoder;
    private List<String> listaDePoderes;
    
    /**
     * Constructor que inicializa un personaje con nombre, salud máxima, poder y lista de poderes.
     * El id se genera automáticamente.
     */
    public Personaje(String nombre, int saludMaxima, Poder poder, List<String> listaDePoderes){
        this.id = contador.getAndIncrement();
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        this.nivelDePoder = poder;
        this.listaDePoderes = new ArrayList<>(listaDePoderes);
    }

    /**
     * Agrega un poder a la lista de poderes del personaje si no lo tiene ya.
     * Muestra un mensaje por consola si el poder ya existe.
     */
    public void agregarPoder(String poder){
        if (listaDePoderes.contains(poder)) {
            System.out.println("Este poder ya lo tiene");
            return;
        }
        this.listaDePoderes.add(poder);
        String respuesta = String.format(poder);
        respuesta += " añadido";
        System.out.println(respuesta);
    }

    /**
     * Elimina un poder de la lista de poderes del personaje si lo tiene.
     * Muestra un mensaje por consola si el poder no existe.
     */
    public void eliminarPoder(String poder){
        if(listaDePoderes.contains(poder)){
            listaDePoderes.remove(poder);
            String respuesta = poder;
            respuesta += " fue eliminado";
            System.out.println(respuesta);
            return;
        }
        System.out.println("Este poder no se encuentra en la lista de poderes");
    }

    /**
     * Devuelve la lista de poderes del personaje.
     */
    public List<String> listarPoderes(){
        return this.listaDePoderes;
    }

    /**
     * Devuelve una representación en String del personaje con todos sus atributos.
     */
    @Override
    public String toString() {
        String respuesta=new String();
        respuesta += "Personaje: ";
        respuesta += getNombre();
        respuesta += ", Vida: ";
        respuesta += getSaludMaxima();
        respuesta += ", Poder: ";
        respuesta += getNivelDePoder();
        respuesta += ", Poderes: ";
        respuesta += getListaDePoderes();
        return respuesta;
    }
}

enum Poder{
    BAJO, MEDIO, ALTO 
}
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
    private List<String> listaDePoderes = new ArrayList<>();
    
    
    public Personaje(String nombre, int saludMaxima, Poder poder, List<String> listaDePoderes){
        this.id = contador.getAndIncrement();
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        this.nivelDePoder = poder;
        this.listaDePoderes = listaDePoderes;
    }
    public void agregarPoder(String poder){
        this.listaDePoderes.add(poder);
    }
}

enum Poder{
    BAJO, MEDIO, ALTO 
}
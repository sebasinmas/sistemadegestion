package com.sebastianb;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeUpdateDTO {
    private String nombre;
    private Integer saludMaxima;
    private Poder nivelDePoder;
    private List<String> listaDePoderes;
}

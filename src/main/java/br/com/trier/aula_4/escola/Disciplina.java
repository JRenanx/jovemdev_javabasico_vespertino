package br.com.trier.aula_4.escola;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Disciplina {

    private String nome;
    private Integer cargaHoraria;
    private Professor professor;
    
    
}

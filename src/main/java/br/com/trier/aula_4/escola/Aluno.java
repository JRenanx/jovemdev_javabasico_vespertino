package br.com.trier.aula_4.escola;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {

    private String nome;
    private List<Disciplina> disciplinas;
    private List<List<Double>> notas;
   
    
    public Aluno() {
   
    }

    
    
}

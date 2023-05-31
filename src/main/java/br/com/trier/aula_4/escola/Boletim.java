package br.com.trier.aula_4.escola;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boletim {

    private Aluno aluno;
    private Disciplina disciplina;
    private List<Double> notas;
    
    
    public Double media() {
        return notas.stream().mapToDouble(nota -> nota).average().orElse(0);
    }
    
    
}

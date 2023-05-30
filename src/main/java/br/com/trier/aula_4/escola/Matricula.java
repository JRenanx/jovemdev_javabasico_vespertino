package br.com.trier.aula_4.escola;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Matricula {

    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
}

package br.com.trier.aula_4.escola;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Matricula {

    @NonNull
    private List<Aluno> alunos;
    @NonNull
    private List<Professor> professores;
    @NonNull
    private List<Disciplina> disciplinas;
    
    
    
    public void cadastraPessoa(Aluno a) {
        alunos.add(a);
    }
    
    public void cadastraProfessor(Professor p) {
        professores.add(p);
    }
    
    public void cadastraDisciplina(Disciplina disciplina, Professor p) {
        disciplina.setProfessor(p);
        disciplinas.add(disciplina);
        
    }
}

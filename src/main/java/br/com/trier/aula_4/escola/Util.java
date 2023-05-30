package br.com.trier.aula_4.escola;

import java.util.List;

public class Util {

    
    
    public void cadastrarProfessor(List<Professor> professores) {
        Professor professor = new Professor("Tafarel", Formacao.POS_GRADUACAO);
        professores.add(professor);
    }
    
    public void cadastrarAlunos(List<Aluno> nome) {
        Aluno aluno = new Aluno();
        
    }
 
    public void cadastraDisciplina(String nome, int cargaHoraria, Professor professor) {
        Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor);
    }
    
    public void disciplinaMatriculada(List<Aluno> alunos, Disciplina disciplina) {
        disciplina.getNome();
    }
    
    public void informaNotas(List<List<Double>> notas) {
        Aluno aluno = new Aluno();
        aluno.setNotas(notas);
    }
    
    public void listarDisciplina(List<Aluno> aluno, String nome) {
        
    }
    
    public void listarDisciplinaPosGraduado(Professor professores, Formacao formacao) {
        professores.getNome();
        formacao.name();
    }
    
}

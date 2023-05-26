package br.com.trier.aula_3.livro;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

    private String nome;
    private int idade;
    private Sexo sexo;

    public void cadastrarAutor(List<Autor> autores) {
        nome = JOptionPane.showInputDialog("Digite o nome do autor:");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor:"));
        sexo = Sexo.escolheSexo();

        Autor autor = new Autor();
        autores.add(autor);

        JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso.");
    }

    @Override
    public String toString() {

        return "Nome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo;
    }
}

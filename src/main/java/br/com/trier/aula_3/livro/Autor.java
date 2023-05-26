package br.com.trier.aula_3.livro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Autor {

    private String nome;
    private int idade;
    private Sexo sexo;

    public void cadastraAutor() throws Exception {

        pegarNome();
        pegarIdade();
        pegarSexo();
    }

    public void pegarNome() throws Exception {
        nome = JOptionPane.showInputDialog("Digite o nome completo do autor").trim();

    }

    public static boolean validaNome(String nome) {
        String padrao = "^[a-zA-ZÀ-ú]+ [a-zA-ZÀ-ú]+$";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    public void pegarIdade() throws Exception {
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
        if (idade <= 0) {
            throw new Exception("Idade inválida!");
        }
    }

    public void pegarSexo() throws Exception {
        sexo = Sexo.escolheSexo();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n    Idade: " + idade + "\n    Sexo: " + sexo.getDescricao() + "\n";
    }

}
package br.com.trier.aula_3.livro;

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
        boolean validador = false;
        while (!validador) {
            try {
                pegarNome();
                pegarIdade();
                pegarSexo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cadastro invalido.");
                continue;
            }
            validador = true;
        }
    }

    public void pegarNome() throws Exception {
        nome = JOptionPane.showInputDialog("Digite o nome completo do Autor");
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
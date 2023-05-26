package br.com.trier.aula_3.livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

    private String titulo;
    private double preco;
    private List<Autor> autores = new ArrayList<>();

    public void cadastrarLivro(List<Livro> livros) {
        titulo = JOptionPane.showInputDialog("Nome do livro: ");
        preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro: "));
       livros.add(null);
      
            
        

    }

    @Override
    public String toString() {

        return "Titulo: " + titulo + "\nPreço: " + preco;
    }
}
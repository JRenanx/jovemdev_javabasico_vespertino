package br.com.trier.aula_3.livro;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Livro {

    private String titulo;
    private double preco;
    private List<Autor> autores = new ArrayList<Autor>();

    public Livro(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public void cadastraLivro(List<Autor> autoresCadastrados) throws Exception {

        preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do livro"));

        pegarTitulo();
        pegarPreco();
        setAutores(new ArrayList<>());
    }

    private void pegarTitulo() throws Exception {
        titulo = JOptionPane.showInputDialog("Titulo do livro:").toLowerCase();
        if (titulo.trim().equals("")) {
            throw new Exception("Digite um titulo!");
        }
    }

    private void pegarPreco() throws Exception {
        preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro:"));
        if (preco <= 0) {
            throw new Exception("Preço inválido!");
        }
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public boolean sexoDoAutor(Sexo sexo) {
        for (Autor autor : this.autores) {
            if (!autor.getSexo().equals(sexo)) {
                return false;
            }
        }
        return true;
    }

    public String listaLivros() {
        String res = "Livros cadastrados:\n\n";
        res += " - Título: " + titulo + "\n";
        res += " - Preço do livro: R$" + preco + "\n";

        for (Autor autor : autores) {
            res += " - Autores: " + autor.getNome() + "\n";
            res += " - Idade: " + autor.getIdade() + "\n";
            res += " - Sexo: " + autor.getSexo() + "\n\n";
        }
        return res;
    }

}
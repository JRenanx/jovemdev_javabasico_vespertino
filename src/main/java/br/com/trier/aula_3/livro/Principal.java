package br.com.trier.aula_3.livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Autor> autores = new ArrayList<>();

        int op = 0;

        do {
            try {
                op = Util.escolheOp();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um numero valido!");
                continue;
            }

            switch (op) {
            case 1:
                Autor autor = new Autor();
                autor.cadastrarAutor(autores);
                autores.add(autor);
                break;
            case 2:
                Livro livro = new Livro();
                livro.cadastrarLivro(livros);
                break;
            case 3:
                Util.listarLivros(livros);
                break;
            case 4:
                Util.pesquisarPorAutor(livros);
                break;
            case 5:
                Util.pesquisarPorFaixaDeValor(livros);
                break;
            case 6:
                Util.listarLivrosAutoresComCrianca(livros);
                break;
            case 7:
                Util.listarLivrosPorSexoAutor(livros);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                break;
            }
        } while (op != 0);

    }
}

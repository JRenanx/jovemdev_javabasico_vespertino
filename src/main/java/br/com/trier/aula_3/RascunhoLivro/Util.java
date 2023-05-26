package br.com.trier.aula_3.RascunhoLivro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_3.livro.Autor;
import br.com.trier.aula_3.livro.Livro;

public class Util {
    
    public static void cadastrarAutor(List<Autor> autores) {
        String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor:");
        String sexoStr = JOptionPane.showInputDialog("Digite o sexo do autor (1 - Masculino, 2 - Feminino):");
        Sexo sexoAutor = null;
        
        switch (sexoStr) {
            case "1":
                sexoAutor = Sexo.MASCULINO;
                break;
            case "2":
                sexoAutor = Sexo.FEMININO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Cadastro de autor cancelado.");
                return;
        }

        int idadeAutor = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor:"));

        Autor autor = new Autor();
        autores.add(autor);

        JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso.");
    }

    public static void cadastrarLivro(List<Livro> livros, List<Autor> autores) {
        Livro livro = new Livro();
        livro.setAutores(autores);
        livros.add(livro);
        
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso.");
    }

    public static void listarLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
        } else {
            StringBuilder output = new StringBuilder();
            for (Livro livro : livros) {
                output.append("Título: ").append(livro.getTitulo()).append("\n");
                output.append("Preço: R$").append(livro.getPreco()).append("\n");

                output.append("Autores:\n");
                for (Autor autor : livro.getAutores()) {
                    output.append("Nome: ").append(autor.getNome()).append("\n");
                    output.append("Sexo: ").append(autor.getSexo()).append("\n");
                    output.append("Idade: ").append(autor.getIdade()).append("\n");
                }

                output.append("-------------------------\n");
            }
            JOptionPane.showMessageDialog(null, output.toString());
        }
    }

    public static void pesquisarPorAutor(List<Livro> livros) {
        String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor:");
        boolean encontrado = false;
        StringBuilder output = new StringBuilder();
        for (Livro livro : livros) {
            for (Autor autor : livro.getAutores()) {
                if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                    output.append("Título: ").append(livro.getTitulo()).append("\n");
                    output.append("Preço: R$").append(livro.getPreco()).append("\n");
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            output.append("Nenhum livro encontrado para o autor informado.");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void pesquisarPorFaixaDeValor(List<Livro> livros) {
        double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo:"));
        double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo:"));

        boolean encontrado = false;
        StringBuilder output = new StringBuilder();
        for (Livro livro : livros) {
            if (livro.getPreco() >= valorMinimo && livro.getPreco() <= valorMaximo) {
                output.append("Título: ").append(livro.getTitulo()).append("\n");
                output.append("Preço: R$").append(livro.getPreco()).append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            output.append("Nenhum livro encontrado na faixa de valor informada.");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void listarLivrosAutoresComCrianca(List<Livro> livros) {
        boolean encontrado = false;
        StringBuilder output = new StringBuilder();
        for (Livro livro : livros) {
            for (Autor autor : livro.getAutores()) {
                if (autor.getIdade() <= 12) {
                    output.append("Título: ").append(livro.getTitulo()).append("\n");
                    output.append("Preço: R$").append(livro.getPreco()).append("\n");
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            output.append("Nenhum livro encontrado cujos autores tenham crianças.");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }

    public static void listarLivrosPorSexoAutor(List<Livro> livros) {
        String sexoStr = JOptionPane.showInputDialog("Digite o sexo desejado (1 - Masculino, 2 - Feminino):");
        Sexo sexo;
        
        switch (sexoStr) {
            case "1":
                sexo = Sexo.MASCULINO;
                break;
            case "2":
                sexo = Sexo.FEMININO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Listagem de livros cancelada.");
                return;
        }

        boolean encontrado = false;
        StringBuilder output = new StringBuilder();
        for (Livro livro : livros) {
            boolean mesmoSexo = true;
            for (Autor autor : livro.getAutores()) {
                if (autor.getSexo() != sexo) {
                    mesmoSexo = false;
                    break;
                }
            }
            if (mesmoSexo) {
                output.append("Título: ").append(livro.getTitulo()).append("\n");
                output.append("Preço: R$").append(livro.getPreco()).append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            output.append("Nenhum livro encontrado escrito apenas por ").append(sexo);
        }

        JOptionPane.showMessageDialog(null, output.toString());}

    public static Autor buscarAutorPorNome(List<Autor> autores, String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null;
    }

    static int escolheOp() {
        String menu = "1 - Cadastrar Autor \n" 
                + "2 – Cadastrar Livros \n" 
                + "3 - Listar todos os livros cadastrados \n"
                + "4 - Pesquisar por autor \n" 
                + "5 - Pesquisar por faixa de valor do livro \n"
                + "6 - Listar todos os livros cujo autores tenham crianças \n"
                + "7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens\n\n"
                + "0 - Sair";
        


        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}
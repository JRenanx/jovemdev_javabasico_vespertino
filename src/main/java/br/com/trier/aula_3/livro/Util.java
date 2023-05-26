package br.com.trier.aula_3.livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Util {

    public static void cadastraAutor(List<Autor> autores) throws Exception {
        Autor autor = new Autor();
        autor.cadastraAutor();
        autores.add(autor);
    }

    public static void cadastraLivro(List<Autor> autores, List<Livro> livros) throws Exception{
        String titulo = JOptionPane.showInputDialog("Nome do Livro").toLowerCase();
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do livro"));

        Livro livro = new Livro(titulo, preco);

        StringBuilder autorBuilder = new StringBuilder();
        for (int i = 0; i < autores.size(); i++) {
            autorBuilder.append((i + 1)).append(". ").append(autores.get(i).getNome()).append("\n");
        }

        int count = 0;
        boolean maisAutores = true;
        while (maisAutores && count < 4) {
            int autorEscolhido;
            do {
                autorEscolhido = Integer.parseInt(
                        JOptionPane.showInputDialog("Selecione o número do autor:\n" + autorBuilder.toString()));

                if (autorEscolhido < 1 || autorEscolhido > autores.size()) {
                    JOptionPane.showMessageDialog(null, "Número de autor inválido. Tente novamente.");
                }
            } while (autorEscolhido < 1 || autorEscolhido > autores.size());

            Autor autor = autores.get(autorEscolhido - 1);
            livro.adicionarAutor(autor);

            count++;

            if (count < 4) {
                String resposta = JOptionPane.showInputDialog(
                        "Cadastrar mais um autor? ('S' / 'N')\n Autores cadastrados: " + count + " \n(Limite:4)");         
                if (resposta.equalsIgnoreCase("n")) {
                    maisAutores = false;
                } 
            } else {
                JOptionPane.showMessageDialog(null, "Limite dos 4 autores atingido.");
            }
        }

        livros.add(livro);
    }

    public static String listaTodosLivros(List<Livro> livros) {
        String res = "";
        for (Livro livro : livros) {
            res += livro.listaLivros();
        }
        return res;
    }

    public static void pesquisarLivrosPorAutor(List<Livro> livros) {
        String Pesquis = JOptionPane.showInputDialog("Digite o nome do autor:");

        boolean achou = false;
        StringBuilder encontrados = new StringBuilder();

        for (Livro livro : livros) {
            for (Autor autor : livro.getAutores()) {
                if (autor.getNome().equalsIgnoreCase(Pesquis)) {
                    encontrados.append("- Título: ").append(livro.getTitulo()).append("\n").append("  Preço: ")
                            .append(livro.getPreco()).append("\n\n");
                    achou = true;
                    break;
                }
            }
        }

        if (achou) {
            JOptionPane.showMessageDialog(null, "Livros do autor '" + Pesquis + "':\n\n" + encontrados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado do autor '" + Pesquis + "'.");
        }
    }

    public static void LivrosPorValor(List<Livro> livros) {
        double valorMin = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo:"));
        double valorMax = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo:"));

        StringBuilder res = new StringBuilder(
                "Livros com valor de R$ " + valorMin + " a R$ " + valorMax + ":\n\n");

        boolean achouLivros = false;

        for (Livro livro : livros) {
            if (livro.getPreco() >= valorMin && livro.getPreco() <= valorMax) {
                res.append("Título: ").append(livro.getTitulo()).append("\n");
                res.append("Preço: R$ ").append(livro.getPreco()).append("\n");
                res.append("\n");
                achouLivros = true;
            }
        }

        if (!achouLivros) {
            res.append("Nenhum livro encontrado com esse preço.");
        }

        JOptionPane.showMessageDialog(null, res.toString());
    }

    public static void listarLivrosComCriancas(List<Livro> livros) {
        StringBuilder res = new StringBuilder("Livros escritos por crianças (Menos de 12) :\n\n");

        boolean achouLivros = false;

        for (Livro livro : livros) {
            boolean autorCrianca = false;
            for (Autor autor : livro.getAutores()) {
                if (autor.getIdade() <= 12) {
                    autorCrianca = true;
                    break;
                }
            }
            if (autorCrianca) {
                res.append("Título: ").append(livro.getTitulo()).append("\n");
                res.append("Preço: R$ ").append(livro.getPreco()).append("\n");
                res.append("Autores:\n");
                for (Autor autor : livro.getAutores()) {
                    res.append("- ").append(autor.getNome()).append("\n");
                }
                res.append("\n");
                achouLivros = true;
            }
        }

        if (!achouLivros) {
            res.append("Nenhum livro encontrado com autores crianças (menos de 12).");
        }

        JOptionPane.showMessageDialog(null, res.toString());
    }
    

    public static String listarLivrosPorSexoAutores(List<Livro> livros) {
        List<Livro> sexoLivro = new ArrayList<>();
        Sexo sexo = Sexo.escolheSexo();
        for (Livro livro : livros) {
            if (livro.sexoDoAutor(sexo)) {
                sexoLivro.add(livro);
            }
        } 
        String sexoteste ="";
        for(Livro livro : sexoLivro) {
            sexoteste += "Titulo: " + livro.getTitulo() + "\n";
            
        }
        return sexoteste;
        
    }
    
  

    public static int escolheMenu() {
        String menu = "********MENU********\n"
                + "1 - Cadastrar Autor \n" + "2 – Cadastrar Livros \n" + "3 - Listar todos os livros cadastrados \n"
                + "4 - Pesquisar por autor \n" + "5 - Pesquisar por faixa de valor do livro \n"
                + "6 - Listar todos os livros cujo autores tenham crianças \n"
                + "7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens\n\n" + "0 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}
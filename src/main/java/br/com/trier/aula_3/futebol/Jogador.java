package br.com.trier.aula_3.futebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {

    private String nome;
    private int numeroCamisa;
    private int golsMarcados;

    public Jogador() {

    }

    public void cadastraJogador() {
        this.nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
        if (!validarNomeCadastro()) {
            JOptionPane.showInputDialog("Digite o nome do jogador");
        }
        this.numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa:"));
        if (this.validarNumeroCadastro()) {
            Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa:"));
        }
        this.golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados no campeonato:"));
        if (!validarGolsCadastro()) {
            Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados no campeonato:"));
        }

    }

    boolean validarNomeCadastro() {
        if (this.nome.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de jogador invalido!");
            return false;
        }
        return true;
    }

    boolean validarNumeroCadastro() {
        if (numeroCamisa <= 0 || numeroCamisa > 99) {
            JOptionPane.showMessageDialog(null, "Numero da camisa invalido!");
            return false;
        }
        return true;
    }

    boolean validarGolsCadastro() {
        if (golsMarcados < 0) {
            JOptionPane.showMessageDialog(null, "Quantidade de gols marcados invalido!");
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
       return "Nome: " + nome + "\nNúmero: " + numeroCamisa + "\nGols: " + golsMarcados;
    }
}
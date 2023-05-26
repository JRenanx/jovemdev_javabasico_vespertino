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


    public void cadastraJogador() {
        nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
        numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa:"));
        golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados no campeonato:"));
    }
    
    @Override
    public String toString() {
        return nome + "-" + numeroCamisa + "-" +  golsMarcados + "\n";
    }

}
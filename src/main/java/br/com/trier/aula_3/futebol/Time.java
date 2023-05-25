package br.com.trier.aula_3.futebol;

import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

    private String nome;
    private List<Jogador> jogadores;
    private int golsTotais;

    public Time cadastraTime() {
        jogadores = new ArrayList<>();
        nome = JOptionPane.showInputDialog("Nome do time").toUpperCase();
        if (!validaTime()) {
            JOptionPane.showInputDialog("Nome invalido.");
        }
        
        int opt = 1;

        do {
            jogadores.add(new Jogador());
            opt++;
            if (opt == 11) {
                int opt2 = Integer.parseInt(JOptionPane.showInputDialog("Deseja parar o cadastro de jogadores? 1- Sim e 2 - Não"));
                if (opt2 == 1) {
                    opt = 0;
                }
            }
        } while (opt != 0 && opt < 3);

        return this;
    }
    

    public boolean validaTime() {
        if (this.nome.trim().equals("")) {
            JOptionPane.showInputDialog("Digite o nome do time:");
            return false;
        }
        return true;
    }

    public String jogadoresDoTime() {
        String res = "";
        for (Jogador jogador : jogadores) {
            res += jogador.toString();

        }
        return res;
    }

    @Override
    public String toString() {
        return "Nome do time: " + nome + "\n";
    }
}
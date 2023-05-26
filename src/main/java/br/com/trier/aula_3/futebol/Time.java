package br.com.trier.aula_3.futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

    private String nome;
    private List<Jogador> jogadores = new ArrayList<>();

    public void cadastrar() {
        nome = JOptionPane.showInputDialog("Nome do time");
        String op = "";
        do {
            Jogador j = new Jogador();
            j.cadastraJogador();
            jogadores.add(j);
            op = JOptionPane.showInputDialog("Deseja parar o cadastro de jogadores? S- Sim e N - Não" );
        }while(op.equalsIgnoreCase("S"));;
    }   

    public String jogadoresDoTime() {
        String res = "Jogadores do time " + nome + "\n";
        for (Jogador jogador : jogadores) {
            res += jogador;
        }
        return res;
    }

    public int pegarGols() {
        int gols = 0;
        for (Jogador jogador : jogadores) {
            gols += jogador.getGolsMarcados();
        }
        return gols;
    }

    public Jogador pegarArtilheiro() {
        Jogador artilheiro = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getGolsMarcados() > artilheiro.getGolsMarcados()) {
                artilheiro = jogador;
            }
        }
        return artilheiro;
    }

}
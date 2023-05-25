package br.com.trier.aula_3.futebol;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

    static String imprimeTimes(List<Time> times) {
        String res = "";
        for (Time time : times) {
            res += times.toString();
        }
        return res;
    }

    static Jogador artilheiro(List<Time> times) {
        Jogador artilheiro = new Jogador();
        artilheiro.setGolsMarcados(0);
        for (Time time : times) {
            for (int i = 0; i < time.getJogadores().size(); i++) {
                Jogador jogador = time.getJogadores().get(i);
                if (jogador.getGolsMarcados() > artilheiro.getGolsMarcados()) {
                    artilheiro.setNome(jogador.getNome());
                    artilheiro.setNumeroCamisa(jogador.getNumeroCamisa());
                    artilheiro.setGolsMarcados(jogador.getGolsMarcados());
                }
            }

        }
        return artilheiro;
    }

    static int escolheOp() {
        String menu = "1 - Cadastrar time\n" + "2 - Listar todos os jogadores de um time\n"
                + "3 - Procurar artilheiro \n" + "4 - Mostrar time com mais gols\n" + "5 - Mostrar todos os times\n\n"
                + "6 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

}
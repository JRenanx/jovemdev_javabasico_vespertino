package br.com.trier.aula_3.futebol;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {

    public static void cadastraTime(List<Time> time) {
        Time t = new Time();
        t.cadastrar();
        time.add(t);
    }

    public static Time escolheTime(List<Time> times) {
        String menu = "Escolha um time\n";
        int pos = 1;
        for (Time time : times) {
            menu += pos + " - " + time.getNome() + "\n";
            pos++;
        }
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return times.get(op - 1);

    }

    public static String artilheiroCampeonato(List<Time> times) {
        Jogador artilheiro = new Jogador();
        for (Time time : times) {
            if (time.pegarArtilheiro().getGolsMarcados() > artilheiro.getGolsMarcados()) {
                artilheiro = time.pegarArtilheiro();
            }
        }
        return artilheiro.toString();
    }

    public static String timeMaisGols(List<Time> times) {
        Time timeComMaisGols = new Time();
        for (Time time : times) {
            if (time.pegarGols() > timeComMaisGols.pegarGols()) {
                timeComMaisGols = time;
            }
        }
        return timeComMaisGols.getNome();
    }

    static int escolheOp() {
        String menu = "1 - Cadastrar times\r\n" + "2 - Listar todos jogadores de um time\r\n"
                + "3 - Verificar artilheiro do campeonato.\r\n"
                + "4 - verificar qual time fez mais gols no campeonato\r\n" + "5 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

}
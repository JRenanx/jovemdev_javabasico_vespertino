package br.com.trier.aula_3.futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        List<Time> times = new ArrayList<>();

        int op = 0;

        do {
            try {
                op = Util.escolheOp();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um numero valido.");
                continue;
            }

            if (op == 1) {
                Util.cadastraTime(times);
            }
            if (op == 2) {
                
            }
            if (op == 3) {
                Util.artilheiroCampeonato(times);
            }
            if (op == 4) {
                Util.timeMaisGols(times);
            }
        

        } while (op != 5);

    }
}
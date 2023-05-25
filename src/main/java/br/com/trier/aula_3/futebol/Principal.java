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
                Time time = new Time().cadastraTime();
                times.add(new Time());
            }
            if (op == 2) {
                JOptionPane.showMessageDialog(null, "");
            }
            if (op == 3) {
                JOptionPane.showMessageDialog(null, "");
            }
            if (op == 4) {
                JOptionPane.showInputDialog(null, Util.artilheiro(times));
            }
            if (op == 5) {
                JOptionPane.showMessageDialog(null, Util.imprimeTimes(times));
            }

        } while (op != 6);

    }
}
package br.com.trier.aula_2.correcao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        List<Carro> lista = new ArrayList<>();
        int op = 0;
        do {
            op = Util.escolheOp();
            switch (op) {
            case 1:
                Carro c = new Carro();
                c.cadastraCarro();
                lista.add(c);
                break;

            case 2:
                JOptionPane.showMessageDialog(null, Util.buscarPorPeriodo(lista));
                break;

            case 3:
                JOptionPane.showMessageDialog(null, Util.buscarMarca(lista));
                break;

            case 4:
                JOptionPane.showMessageDialog(null, Util.buscarPorCor(lista));
                break;

            }
        } while (op != 5);

    }
}

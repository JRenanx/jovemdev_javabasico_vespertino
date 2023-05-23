package br.com.trier.aula_2.carro;

import javax.swing.JOptionPane;

public class Carro {

    String marca;
    int ano;
    Cores cor;

    void cadastrarCarros() {
        marca = JOptionPane.showInputDialog("Marca: ");
        ano = Integer.parseInt(JOptionPane.showInputDialog("Ano: "));

        
        int i = 1;
        for (Cores cores : Cores.values()) {
            i++;

        }
        int opcaoCor = Integer.parseInt(JOptionPane.showInputDialog("\"1 - BRANCO"
                + "\n2 - VERMELHO"
                + "\n3 - PRATA"
                + "\n4 - CINZA"
                + "\n5 - PRETO"));

    }

    void periodosDeFabricacao() {
        int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano incial: "));
        int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final: "));

    }

}

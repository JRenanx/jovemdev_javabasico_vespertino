package br.com.trier.aula_2.carro;

import javax.swing.JOptionPane;

public class Carro {

    String marca;
    int ano;
    Cores cor;

    void cadastrarCarros() {

        marca = JOptionPane.showInputDialog("Marca: ").toUpperCase();
        ano = Integer.parseInt(JOptionPane.showInputDialog("Ano: "));
        Cores[] cores = Cores.values();
        String[] corEscolhida = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            corEscolhida[i] = cores[i].name();

        }
        String corString = (String) JOptionPane.showInputDialog(null, "Selecione a cor do carro", "Cadastrar carro.",
                JOptionPane.PLAIN_MESSAGE, null, corEscolhida, corEscolhida[0]);

        cor = Cores.valueOf(corString);

        if (marca.isEmpty() || ano == 0) {
            JOptionPane.showMessageDialog(null, "Todos os atributos devem ser preenchidos.");
            return;
        }
    }

    String imprimeperiodosDeFabricacao() {
        return "Ano: " + ano + "\n";

    }

    String imprimeMarca() {

        return "Marca: " + marca  + "\n";
    }

    String imprimeCor() {
        return "Cor: " + cor + "\n";
    }

}

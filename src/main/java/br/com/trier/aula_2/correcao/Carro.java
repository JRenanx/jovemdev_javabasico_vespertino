package br.com.trier.aula_2.correcao;

import javax.swing.JOptionPane;


public class Carro {

    String marca;
    int ano;
    Cores cor;

    void cadastraCarro() {
        marca = JOptionPane.showInputDialog("marca:");
        ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
        cor = Cores.escolheCor();
        if (!validar()) {
            cadastraCarro();
        }
    }

    boolean validar() {
        if (marca.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Marca aqui");
            return false;
        }
        if (ano <= 0 || ano > 2025) {
            JOptionPane.showMessageDialog(null, "Ano invalido");
            return false;
        }
        if (cor == null) {
            JOptionPane.showMessageDialog(null, "Cor invalido");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Marca: " + marca + "\n" + "Ano: " + ano + "\n" + "Cor: " + cor + "\n" + "                \n";
    }

    boolean isFabricadoPeriodo(int anoInicial, int anoFinal) {
        return ano >= anoInicial && ano <= anoFinal;
    }

    boolean isMarca(String marcaBusca) {
        return marcaBusca.equalsIgnoreCase(marca);
    }
    boolean isCor(Cores cor) {
        return cor == this.cor;
    }

}

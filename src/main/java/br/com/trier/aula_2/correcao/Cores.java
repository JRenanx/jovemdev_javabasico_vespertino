package br.com.trier.aula_2.correcao;

import javax.swing.JOptionPane;

public enum Cores {

    BRANCO(1, "Branco"), VERMELHO(2, "Vermelho"), AZUL(3, "Azul"), PRATA(4, "Prata"), PRETO(5, "Preto");

    int codigo;
    String descricao;

    private Cores(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    static Cores buscaCodigo(int codigo) {
        for (Cores cor : Cores.values()) {
            if (codigo == cor.codigo) {
                return cor;
            }
        }
        return null;
    }
    
    static Cores escolheCor() {
        String menu = "Escolha a cor: ";
        for (Cores cor : Cores.values()) {
            menu += cor.codigo + " - " + cor.descricao + "\n";
            
        }
        int escolha = Integer.parseInt(JOptionPane.showInternalInputDialog(null, menu));
        return buscaCodigo(escolha);
    }
}
package br.com.trier.aula_2.correcao;

import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public enum Cores {

    PRETO (1, "Preto"),
    BRANCO (2, "Branco"),
    AZUL (3, "Azul"),
    VERMELHO (4, "Vermelho"),
    PRATA (0, "Prata");
    
    private int codigo;
    private String descricao;
    
    private Cores(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    static Cores buscaPorCodigo(int codigo) {
        for(Cores cor: Cores.values()) {
            if(codigo == cor.codigo) {
                return cor;
            }
        }
        return null;
    }
    
    static Cores escolheCor() {
        String menu = "Escolhas uma cor:\n";
        for (Cores cor : Cores.values()) {
            menu += cor.codigo + " - " + cor.descricao + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return buscaPorCodigo(escolha);
    }
    
    
    
    

}
package br.com.trier.aula_3.livro;

import javax.swing.JOptionPane;

public enum Sexo {

    MASCULINO(1, "MASCULINO"), FEMININO(2, "FEMININO");

    private int codigo;
    private String descricao;

    private Sexo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    static Sexo buscaPorCodigo(int codigo) {
        for (Sexo sexo : Sexo.values()) {
            if (codigo == sexo.codigo) {
                return sexo;
            }
        }
        return null;
    }

    static Sexo escolheSexo() {
        String menu = "Escolhas uma cor:\n";
        for (Sexo sexo : Sexo.values()) {
            menu += sexo.codigo + " - " + sexo.descricao + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return buscaPorCodigo(escolha);
    }
}

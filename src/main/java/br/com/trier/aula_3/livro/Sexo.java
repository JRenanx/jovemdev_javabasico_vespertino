package br.com.trier.aula_3.livro;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public enum Sexo {

    MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

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

    public static Sexo escolheSexo() {
        Sexo[] sexo = Sexo.values();
        String[] sexoDescricao = new String[sexo.length];
        for (int i = 0; i < sexo.length; i++) {
            sexoDescricao[i] = sexo[i].getCodigo() + " - " + sexo[i].getDescricao();
        }

        JComboBox<String> comboBox = new JComboBox<>(sexoDescricao);
        int escolheSexo = JOptionPane.showConfirmDialog(null, comboBox, "Escolha o sexo do autor",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (escolheSexo == JOptionPane.OK_OPTION) {
            int selecionaSexo = comboBox.getSelectedIndex();
            if (selecionaSexo >= 0 && selecionaSexo < sexo.length) {
                return sexo[selecionaSexo];
            }
        }
        return null;
    }

}
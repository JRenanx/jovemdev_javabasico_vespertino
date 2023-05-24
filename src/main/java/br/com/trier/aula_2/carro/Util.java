package br.com.trier.aula_2.carro;

import javax.swing.JOptionPane;

public class Util {

    static int escolheOp() {
        String menu = "Menu:"
                + "\n1 - Cadastrar carro."
                + "\n2 - Listar carros por periodo de fabricaçao"
                + "\n3 - Listar carros por marca " 
                + "\n4 - Listar carros por cor" 
                + "\n\n 5 - Sair";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}

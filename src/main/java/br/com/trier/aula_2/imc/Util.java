package br.com.trier.aula_2.imc;

import javax.swing.JOptionPane;

public class Util {

    static int escolheOp() {
        String menu = "1 - cadastrar" + "\n2 - Avaliar" + "\n\n3 - Sair";
        
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
    
  
}

package br.com.trier.aula_2.imc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PrincipalImc {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        int op = 0;
        do {
            op = Util.escolheOp();
            if (op ==1) {
                Pessoa p = new Pessoa();
                p.cadastrar();
                pessoas.add(p);
            }
            if (op ==2) {
               String resultado= "*** IMC ***\n";
               for(Pessoa p : pessoas) {
                   resultado += p.imprimir();
               }
               JOptionPane.showMessageDialog(null, resultado);
                
            }
        } while (op !=3);
    }
}

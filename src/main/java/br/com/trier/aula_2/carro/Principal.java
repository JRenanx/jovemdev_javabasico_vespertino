package br.com.trier.aula_2.carro;

import java.util.ArrayList;
import java.util.List;


public class Principal {

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<Carro>();
        Carro c = new Carro();
        int op = 0;
        do {
            op = Util.escolheOp();
            if (op ==1) {
                
                c.cadastrarCarros();
                carros.add(c);
            }
            if (op ==2) {
                c.periodosDeFabricacao();
                
            }
        } while (op != 5);
        
    }
}

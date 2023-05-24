package br.com.trier.aula_2.carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<Carro>();

        int op = 0;
        do {
            op = Util.escolheOp();
            if (op == 1) {
                Carro c = new Carro();
                c.cadastrarCarros();
                carros.add(c);
            }

            if (op == 2) {
                int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o período do ano de início"));
                int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o período do ano final"));
                String res = "Período\n";

                List<Carro> carroPorPeriodo = new ArrayList<>();
                for (Carro carro : carros) {
                    if (anoInicial <= carro.ano && anoFinal >= carro.ano) {
                        carroPorPeriodo.add(carro);
                    }
                }
                if (carroPorPeriodo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Periodo não registrado");
                } else {
                    for (Carro c : carroPorPeriodo) {
                        res += c.imprimeperiodosDeFabricacao();

                    }
                    JOptionPane.showMessageDialog(null, res);

                }
 
            }

            if (op == 3) {
                String infoMarca = JOptionPane.showInputDialog("Digite a marca: \n");
                String res = "";

                List<Carro> carroMarca = new ArrayList<>();
                for (Carro carro : carros) {
                    if (carro.marca.equals(infoMarca.toUpperCase())) {
                        carroMarca.add(carro);
                    }
                }
                if (carroMarca.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Marca não registrada.");
                } else {
                    for (Carro c : carros) {
                        res += c.imprimeMarca();
                    }
                    JOptionPane.showMessageDialog(null, "Marcas:\n" + res);

                }
            }

            if (op == 4) {
                int infoCor = Integer.parseInt(JOptionPane.showInputDialog("Escolha a cor desejada: \n\n"
                        + "1 - BRANCO\n" + "2 - VERMELHO\n" + "3 - PRATA\n" + "4 - CINZA\n" + "5 - PRETO"));
                String res = "Lista de carros:\n";
                List<Carro> carrosCores = new ArrayList<>();
                for (Carro carro : carros) {
                    if (carro.cor.ordinal() == infoCor - 1) {
                        carrosCores.add(carro);
                    }
                }
                if (carrosCores.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cor não registrada.");
                } else {
                    for (Carro c : carrosCores) {
                        res += c.imprimeCor();
                    }

                    JOptionPane.showMessageDialog(null, res);
                }

            }
        } while (op != 5);

    }
}

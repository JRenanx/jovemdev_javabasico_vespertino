package br.com.trier.aula_2.correcao;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {
    
    static double calculaPercentual(List<Carro> carros, int qnt) {
        return(double) qnt / (double) carros.size() * 100;
    }
    
    static String buscarPorPeriodo(List<Carro> carros) {
       int anoIinicial= Integer.parseInt(JOptionPane.showInputDialog("Ano inicial: "));
       int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Ano final: "));
       String res = "Carros fabricado entre %s e %s".formatted(anoIinicial, anoFinal);
       int count = 0;
       for(Carro c: carros) {
           if (c.isFabricadoPeriodo(anoIinicial, anoFinal)) {
            count++;
            res += c.toString();
        }
       }
       res += "Representa %s % dos carros ".formatted(calculaPercentual(carros, count));
       res += "\n";
       return res;
    }
    
    static String buscarMarca(List<Carro> carros) {
        String marca= JOptionPane.showInputDialog("Marca: ");
        String res = "Carros da marca %s e %s".formatted(marca);
        int count = 0;
        for(Carro c: carros) {
            if (c.isMarca(marca)) {
             count++;
             res += c.toString();
         }
        }
        res += "Representa %s % dos carros ".formatted(calculaPercentual(carros, count));
        res += "\n";
        return res;
     }
    
    static String buscarPorCor(List<Carro> carros) {
        Cores cor = Cores.escolheCor();
        String res = "Escolha as cores: ".formatted(cor);
        int count = 0;
        for(Carro c: carros) {
            if (c.isCor(cor)) {
             count++;
             res += c.toString();
         }
        }
        res += "Representa %s % dos carros ".formatted(calculaPercentual(carros, count));
        res += "\n";
        return res;
     }
    
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

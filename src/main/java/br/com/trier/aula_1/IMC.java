package br.com.trier.aula_1;

import javax.swing.JOptionPane;

public class IMC {

    public static void main(String[] args) {

        int pessoas = 0;

        while (true) {
            pessoas = Integer.parseInt(JOptionPane
                    .showInputDialog("Deseja calcular o IMC de uma pessoa? \n(Digite 0 para sair)"));

            if (pessoas < 1) {
                break;
            }

            for (int i = 0; i < pessoas; i++) {

                String nome = JOptionPane.showInputDialog("Digite o nome da " + (i + 1) + "ª pesssoa");
                String sexo = JOptionPane
                        .showInputDialog("Digite o sexo da " + (i + 1) + "ª pesssoa (Masculino/Feminimo)").toUpperCase();
                double altura = Integer
                        .parseInt(JOptionPane.showInputDialog("Digite o altura da " + (i + 1) + "ª pesssoa em cm"));
                double peso = Double
                        .parseDouble(JOptionPane.showInputDialog("Digite o peso da " + (i + 1) + "ª pesssoa"));

                double imc = calculaImc(altura, peso);
                String tabelaImc = tabelaImc(imc);
                
                JOptionPane.showMessageDialog(null, "O Imc de " + nome +"\nSexo: " + sexo.charAt(0) + "\nAltura de " + altura + "\nPeso de " + peso +"\nÉ de :" + tabelaImc  );

            }

        }
    }

    public static double calculaImc(double altura, double peso) {

        return  peso / (altura * altura);
    }

    public static String tabelaImc(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau 1";
        } else if (imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }

    }
}
package br.com.trier.aula_2.imc;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pessoa {

    String nome;
    char sexo;
    double altura;
    double peso;

    double calculaImc() {
        return peso / (altura * altura);
    }

    void cadastrar() {
        nome = JOptionPane.showInputDialog("Nome:");
        sexo = JOptionPane.showInputDialog("Sexo:").toLowerCase().charAt(0);
        altura = Double.parseDouble(JOptionPane.showInputDialog("Altura:"));
        peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));

    }

    String formatarValor(double vl) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(vl);
    }

    String imprimir() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nAltura: " + altura + "\nPeso: " + peso + "\nImc: "
                + formatarValor(calculaImc()) + "\n" + avaliaImc();
    }

    String avaliaImc() {
        String resultado = "Nao identificado";
        double imc = calculaImc();
        if (sexo == 'F') {
            imc = imc * 0.9;
        } else if (imc <= 18.5) {
            resultado = "\nAbaixo do peso";
        } else if (imc > 18.5 && imc < 24.9) {
            resultado = "\nPeso normal";
        } else if (imc > 25 && imc < 29.9) {
            resultado = "\nSobrepeso";
        } else if (imc > 30 && imc < 34.9) {
            resultado = "\nObesidade Grau 1";
        } else if (imc > 35 && imc < 39.9) {
            resultado = "\nObesidade Grau 2";
        } else if (imc > 40) {
            resultado = "\ntObesidade Grau 3";
        }
        return resultado;
    }
}

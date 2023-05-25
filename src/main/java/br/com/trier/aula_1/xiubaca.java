package br.com.trier.aula_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class xiubaca {

    static List<String> nome = new ArrayList();
    static List<String> sexo = new ArrayList();
    static List<Double> altura = new ArrayList();
    static List<Double> peso = new ArrayList();

    public static void main(String[] args) {

        String menu = JOptionPane
                .showInputDialog("Digite 1 para cadastrar." + "\nDigite 2 para Avaliar" + "\n\nDigite 3 para sair");
        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (op == 1) {
                cadastrarImc();
            }
            if (op == 2) {
                avaliar();
            }

        } while (op != 3);
    }

    public static void cadastrarImc() {

        nome.add(JOptionPane.showInputDialog("Nome:"));
        sexo.add(JOptionPane.showInputDialog("Sexo:"));
        altura.add(Double.parseDouble(JOptionPane.showInputDialog("altura:")));
        peso.add(Double.parseDouble(JOptionPane.showInputDialog("peso:")));
    }

    public static void avaliar() {
        String resultado = "Imc:";
        for (int i = 0; i < nome.size(); i++) {
            String nomes = nome.get(i);
            String sexos = sexo.get(i);
            double alturas = altura.get(i);
            double pesos = peso.get(i);
            double imc = pesos / (alturas * alturas);
            String avaliacao = avaliarImc(sexos, imc);
            resultado += "\nNome: " + nomes + "\nSexo: " + sexos + "\nAltura: " + alturas + "\nPeso: " + pesos
                    + "\nImc: " + imc + avaliacao;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static String avaliarImc(String sexo, double imc) {
        if (sexo.equalsIgnoreCase("M")) {
            if (imc < 18.5) {
                JOptionPane.showMessageDialog(null, "Abaixo do peso");
            }
            if (imc > 18.5 && imc < 24.9) {
                JOptionPane.showMessageDialog(null, "Peso normal");
            }
            if (imc > 25 && imc < 29.9) {
                JOptionPane.showMessageDialog(null, "Sobrepeso");
            }
            if (imc > 30 && imc < 34.9) {
                JOptionPane.showMessageDialog(null, "Obesidade Grau 1");
            }
            if (imc > 35 && imc < 39.9) {
                JOptionPane.showMessageDialog(null, "Obesidade Grau 2");
            }
            if (imc > 40) {
                JOptionPane.showMessageDialog(null, "Obesidade Grau 3");
            }
            return "Erro, nao foi possivel avaliar";
        }
        if (sexo.equalsIgnoreCase("F")) {
            return "sim";
        }
        return "sim";
    }
}

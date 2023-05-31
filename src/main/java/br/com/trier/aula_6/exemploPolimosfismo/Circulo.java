package br.com.trier.aula_6.exemploPolimosfismo;

import lombok.Getter;

@Getter
public class Circulo extends Forma {

    private int raio;
    
    
    public Circulo(int raio) {
        super("Circulo");
        this.raio = raio;
    }
    
    public double calculaArea() {
        return Math.PI * Math.pow(getRaio(), 2);
    }

}

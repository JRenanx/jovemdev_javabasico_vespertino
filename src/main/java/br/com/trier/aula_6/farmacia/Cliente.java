package br.com.trier.aula_6.farmacia;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private String nome;
    private double saldo;

    
    public double pagarConta(double valor) {
        if(valor > 0 && getSaldo() >= valor) {
            saldo = getSaldo() - valor;
        }
        return getSaldo();
    }
    
    public void adicionaValor(double valor) {
        saldo = getSaldo() + valor;
    }

}
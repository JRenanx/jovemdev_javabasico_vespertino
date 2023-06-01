package br.com.trier.aula_6.Banco;

import lombok.Getter;

@Getter
public class ContaEspecial extends Contas {

    private double limite;

    public ContaEspecial(Integer numero, Integer agencia, String nomeCorrentista, double saldo, double limite) {
        super(numero, agencia, nomeCorrentista, saldo);
        this.limite = limite;
    }

    @Override
    public boolean saque(double valor) {
        if (getSaldo() + getLimite() >= valor) {
            saldo = getSaldo() - valor;
            return true;
        }
        return false;
    }

}
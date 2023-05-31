package br.com.trier.aula_6.Banco;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrente {

    private Integer numero;
    private String agencia;
    private String nomeCorrentista;
    protected double saldo;

    public ContaCorrente(Integer numero, String agencia, String nomeCorrentista, double saldo) {
        super();
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
    }

    public void deposito(double valorDeposito) {
        saldo = saldo + valorDeposito;
    }

    public void saque(double valorSaque) {
        saldo = saldo - valorSaque;
    }

    public void transferencia(ContaCorrente contaDestino, double valorTransferencia) {
        if (saldo < valorTransferencia) {
            return;
        } else {
            saldo -= valorTransferencia;
            contaDestino.saldo += valorTransferencia;
        }

    }

}
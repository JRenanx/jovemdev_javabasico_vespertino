package br.com.trier.aula_6.Banco;


import lombok.Setter;


@Setter
public class ContaEspecial extends ContaCorrente {

    public ContaEspecial(Integer numero, String agencia, String nomeCorrentista, double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }

    private double limiteSaldo = 500.0;

    @Override
    public void saque(double valorSaque) {
        if (valorSaque <= limiteSaldo) {
            super.saque(valorSaque);
        }
    }

}

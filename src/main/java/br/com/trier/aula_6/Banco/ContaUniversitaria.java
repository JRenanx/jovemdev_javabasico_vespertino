package br.com.trier.aula_6.Banco;

public class ContaUniversitaria extends ContaCorrente {
    
    private final double limiteSaldo = 2000;

    public ContaUniversitaria(Integer numero, Integer agencia, String nomeCorrentista, double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
        if (saldo < 2000) {
            super.saldo = saldo;
        }
    }

    @Override
    public boolean deposito(double valor) {
        if (getSaldo() + valor <= limiteSaldo) {
            return super.deposito(valor);
        }
        return false;
    }

}
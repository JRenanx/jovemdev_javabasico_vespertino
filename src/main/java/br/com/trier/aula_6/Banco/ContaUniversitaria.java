package br.com.trier.aula_6.Banco;

public class ContaUniversitaria extends ContaCorrente {

    public ContaUniversitaria(Integer numero, String agencia, String nomeCorrentista, double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }

    private final double limiteSaldo = 2000.0;

    @Override
    public void saque(double valorSaque) {
        if (valorSaque > saldo) {
            return;
        } else {
            saldo -= valorSaque;
        }
    }

    @Override
    public void deposito(double valorDeposito) {
        if (saldo + valorDeposito > limiteSaldo) {
            return;
        }

        saldo += valorDeposito;
    }

    @Override
    public void transferencia(ContaCorrente contaDestino, double valorTransferencia) {
        if (valorTransferencia > saldo) {
            return;
        }

        if (contaDestino instanceof ContaUniversitaria) {
            double novoSaldoDestino = contaDestino.getSaldo() + valorTransferencia;
            if (novoSaldoDestino > limiteSaldo) {
            }
        } else {
            saldo -= valorTransferencia;
            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
        }

    }
}
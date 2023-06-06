package br.com.trier.aula_6.Banco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter

public class Contas {

    private Integer numero;
    private Integer agencia;
    private String nomeCorrentista;
    protected double saldo;

    public boolean deposito(double valor) {
        if (valor > 0) {
            saldo = getSaldo() + valor;
            return true;
        }
        return false;
    }

    public boolean saque(double valor) {
        if (getSaldo() >= valor) {
            saldo = getSaldo() - valor;
            return true;
        }
        return false;
    }

    public boolean transferencia(double valor, Contas contas) {
        if (saque(valor)) {
            if (contas.deposito(valor)) {
                return true;
            } else {
                deposito(valor);
                return false;
            }
        }
        return false;

    }

}
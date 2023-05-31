package br.com.trier.aula_6.Banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {

    private List<ContaCorrente> contas = new ArrayList<>();

    public void cadastraContaCorrente(ContaCorrente cc) {
        ContaCorrente contaCorrente = cc;
        contas.add(contaCorrente);
    }

    public void cadastraContaEspecial(ContaEspecial ce) {
        ContaEspecial contaEspecial = ce;
        contas.add(contaEspecial);
    }

    public void cadastraContaUniversitaria(ContaUniversitaria cu) {
        ContaUniversitaria contaUniversitaria = cu;
        contas.add(contaUniversitaria);
    }

    public void saque(ContaCorrente conta, double valor) {
        if (verificaContas(conta)) {

            if (conta instanceof ContaCorrente) {
                ContaCorrente contaCorrente = (ContaCorrente) conta;
                contaCorrente.saque(valor);
            } else if (conta instanceof ContaEspecial) {
                ContaEspecial contaEspecial = (ContaEspecial) conta;
                contaEspecial.saque(valor);
            } else {
                ContaUniversitaria contaUni = (ContaUniversitaria) conta;
                contaUni.saque(valor);
            }
        }
    }

    public void deposito(ContaCorrente conta, double valor) {
        if (verificaContas(conta)) {

            if (conta instanceof ContaCorrente) {
                ContaCorrente contaCorrente = (ContaCorrente) conta;
                contaCorrente.deposito(valor);
            } else if (conta instanceof ContaEspecial) {
                ContaEspecial contaEspecial = (ContaEspecial) conta;
                contaEspecial.deposito(valor);
            } else {
                ContaUniversitaria contaUni = (ContaUniversitaria) conta;
                contaUni.deposito(valor);
            }
        }
    }

    public void transferencia(ContaCorrente saque, ContaCorrente deposito, double valor) {
        if (verificaContas(saque) && verificaContas(deposito)) {

            if (saque instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) saque;
                cc.transferencia(deposito, valor);

                if (deposito instanceof ContaUniversitaria) {

                }

            } else if (saque instanceof ContaEspecial) {
                ContaEspecial ce = (ContaEspecial) saque;
                ce.transferencia(deposito, valor);

            } else {
                ContaUniversitaria cu = (ContaUniversitaria) saque;
                cu.transferencia(deposito, valor);
            }
        }
    }

    public boolean verificaContas(ContaCorrente conta) {
        return contas.contains(conta);
    }

    public void limpaTudo() {
        contas.clear();
    }
}
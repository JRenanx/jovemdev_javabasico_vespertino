package br.com.trier.aula_6.Banco;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrente extends Contas{

    public ContaCorrente(Integer numero, Integer agencia, String nomeCorrentista,
            double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }
    
}
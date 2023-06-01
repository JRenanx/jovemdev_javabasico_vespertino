package br.com.trier.aula_6.Banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Caixa {

    List<Contas> contas = new ArrayList<Contas>();
    
    public void addConta(Contas conta) {
        contas.add(conta);
    }
    
    public boolean deposito(double valor, Contas contas) {
        return contas.deposito(valor);
    }
    
    public boolean saque(double valor, Contas contas) {
        return contas.saque(valor);
    }
    
    public boolean transferencia(double valor, Contas origem , Contas destino) {
        return origem.transferencia(valor, destino);
            
    }
}
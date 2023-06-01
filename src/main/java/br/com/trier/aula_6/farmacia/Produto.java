package br.com.trier.aula_6.farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Produto {

    private String nome;
    private int estoque;
    private double valor;

    public boolean vender(Venda venda) {
        estoque = getEstoque() - venda.getQuantidade();
        venda.getCliente().adicionaValor(venda.getQuantidade() * getValor());
        return true;
    }
}
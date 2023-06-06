package br.com.trier.aula_6.farmacia;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Farmacia {

    private List<Venda> vendas = new ArrayList<Venda>();

    public void vender(Cliente cliente, Produto produto, int qt, String medico) {
        Venda v = new Venda(cliente, produto, qt, medico);
        if (produto.vender(v)) {
            vendas.add(v);
        }
    }

    public List<Venda> vendasPorCliente(Cliente c) {

        return vendas.stream().filter(v -> v.verificaCliente(c)).toList();
    }

}
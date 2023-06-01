package br.com.trier.aula_6.farmacia;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    private List<Venda> vendas = new ArrayList<Venda>();

    public void vender(Cliente cliente, Produto produto, int quantidade, String medico) {
        Venda venda = new Venda(cliente, produto, quantidade, medico);
        if(produto.vender(venda)) {
            vendas.add(venda);
        }
    }
    
} 

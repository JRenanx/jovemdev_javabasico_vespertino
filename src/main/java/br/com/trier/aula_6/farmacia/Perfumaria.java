package br.com.trier.aula_6.farmacia;

public class Perfumaria extends Produto {

    public Perfumaria(String nome, int estoque, double valor) {
        super(nome, estoque, valor);
    }
    
    @Override
    public boolean vender(Venda venda) {
        if(getEstoque() >= venda.getQuantidade() && venda.getCliente().getSaldo() < 300) {
            return super.vender(venda);
        }
        return false;
    }
}
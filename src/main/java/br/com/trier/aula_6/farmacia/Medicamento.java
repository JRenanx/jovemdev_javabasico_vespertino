package br.com.trier.aula_6.farmacia;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

    private boolean receita;

    public Medicamento(String nome, int estoque, double valor, boolean receita) {
        super(nome, estoque, valor);
        this.receita = receita;
    }

    @Override
    public boolean vender(Venda venda) {
        if(receita && venda.getMedico() == null) {
            return false;
        }else {
            if (getEstoque() >= venda.getQuantidade()) {
                return super.vender(venda);
            }
            return false;
        }
    }

}
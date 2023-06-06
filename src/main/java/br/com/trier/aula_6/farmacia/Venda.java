package br.com.trier.aula_6.farmacia;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private String medico;
    

    public boolean verificaCliente(Cliente cliente) {
        return cliente.getNome().equalsIgnoreCase(cliente.getNome());
    }

   
}
package br.com.trier.aula_6.exemploPolimosfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Forma {

    private String nome;
    
    public String desenhar() {
        return "Desenhando um "+ getNome();
    }

}

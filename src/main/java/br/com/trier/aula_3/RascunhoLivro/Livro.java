package br.com.trier.aula_3.RascunhoLivro;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

    private String titulo;
    private double preco;
    private List<Autor> autores = new ArrayList<>();

    @Override
    public String toString() {

        return "Titulo: " + titulo + "\nPreço: " + preco;
    }
}

package br.com.trier.aula_4.medicamento.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.medicamento.Pessoa;

@AllArgsConstructor
@Getter
public class PessoaUtil {

    private final List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrarPessoas(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void updatePessoa(Pessoa pessoa) {
        var pessoaVelha = buscarPessoas(pessoa.getId());
        pessoas.remove(pessoaVelha);
        pessoas.add(pessoa);
    }

    public Pessoa buscarPessoas(Long id) {
        for (Pessoa pessoas : pessoas) {
            if (pessoas.getId().equals(id)) {
                return pessoas;
            }
        }
        return new Pessoa();
    }

}
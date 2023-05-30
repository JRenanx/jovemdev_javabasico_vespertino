package br.com.trier.aula_4.medicamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

    private Long id;
    private String nome;
    private Administracao Administracao;
    private List<String> indicacoes;
    private List<String> alergias;

}
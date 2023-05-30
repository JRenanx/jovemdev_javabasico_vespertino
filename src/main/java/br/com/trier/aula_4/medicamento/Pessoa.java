package br.com.trier.aula_4.medicamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long id;
    private String nome;
    private String sintoma;
    private List<String> alergias;
    private List<Medicamento> medicamentos;

}
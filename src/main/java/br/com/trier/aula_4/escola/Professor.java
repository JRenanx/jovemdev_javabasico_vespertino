package br.com.trier.aula_4.escola;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Professor {

    @NonNull
    private String nome;
    @NonNull
    private EnumFormacao formacao;

}

package br.com.trier.aula_5;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Pessoa {

    @NonNull
    private String nome;
    @NonNull
    private String sintoma;
    private List<String> condicoesSaude = new ArrayList<String>();
    private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public void addCondicacaoSaude(String condicaoSaude) {
        this.condicoesSaude.add(condicaoSaude);
    }

    public boolean addMedicamento(Medicamento m) {
        if (m.isIndicado(sintoma) && !m.isContraIndicado(condicoesSaude)) {
            medicamentos.add(m);
            return true;
        }
        return false;
    }
}

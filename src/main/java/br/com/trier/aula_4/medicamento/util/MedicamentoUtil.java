package br.com.trier.aula_4.medicamento.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.medicamento.Medicamento;

@AllArgsConstructor
@Getter
public class MedicamentoUtil {

    private final List<Medicamento> medicamentos = new ArrayList<>();

    public void cadastrarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    
 

    public Medicamento buscarMedicamento(Long id) {
        Medicamento medicamento = new Medicamento();
        for (Medicamento medicamentos : medicamentos) {
            if (medicamentos.getId().equals(id)) {
                medicamento = medicamentos;
            }
        }
        return medicamento;
    }

}
package br.com.trier.aula_5;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Medico {

    List<Pessoa> pessoas = new ArrayList<Pessoa>();
    List<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public void cadastraPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public void cadastraMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public boolean existePessoa(Pessoa p) {
        return pessoas.contains(p);
    }

    public boolean existeMedicamento(Medicamento m) {
        return medicamentos.contains(m);
    }

    public boolean prescreveMedicamento(Pessoa p, Medicamento m) {
        if (existePessoa(p) && existeMedicamento(m)) {
         return p.addMedicamento(m);
        }
        return false;
    }
}

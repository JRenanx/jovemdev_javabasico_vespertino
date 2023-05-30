package br.com.trier.aula_4.medicamento.util;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

import br.com.trier.aula_4.medicamento.Medicamento;
import br.com.trier.aula_4.medicamento.Pessoa;

@AllArgsConstructor
@Getter
public class Util {

    private MedicamentoUtil medicamentoUtil;
    private PessoaUtil pessoaUtil;

    public void cadastrarMedicamento(Medicamento medicamento) {
        medicamentoUtil.cadastrarMedicamento(medicamento);
    }

    public List<Medicamento> buscarMedicamentos() {
        return medicamentoUtil.getMedicamentos();
    }

    public List<Pessoa> buscarPessoas() {
        return pessoaUtil.getPessoas();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaUtil.cadastrarPessoas(pessoa);
    }

    public void prescricaoDeMedicamento(Pessoa pessoa, Medicamento medicamento) {
        if (pessoa == null || medicamento == null) {
            throw new RuntimeException("Pessoa ou medicamento não encontrado.");
        }

        if (!medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
            throw new RuntimeException("Medicamento não indicado para sintoma apresentado pela pessoa.");
        }

        pessoa.getAlergias().forEach(it ->{
            if (medicamento.getAlergias().contains(it)) {
                throw new RuntimeException("Pessoa alérgica ao medicamento.");
            }
        });

        pessoa.getMedicamentos().add(medicamento);

        pessoaUtil.updatePessoa(pessoa);
    }

    public List<Pessoa> buscarPessoasEMedicamento() {
        return pessoaUtil.getPessoas();
    }

}
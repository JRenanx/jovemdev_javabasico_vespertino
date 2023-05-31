package repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamento.Administracao;
import br.com.trier.aula_4.medicamento.Medicamento;
import br.com.trier.aula_4.medicamento.Pessoa;
import br.com.trier.aula_4.medicamento.util.MedicamentoUtil;
import br.com.trier.aula_4.medicamento.util.PessoaUtil;
import br.com.trier.aula_4.medicamento.util.Util;

class MedicamentoTeste {

    private Util util;

    @BeforeEach
    void init() {
        util = new Util(new MedicamentoUtil(), new PessoaUtil());
    }

    @Test
    @DisplayName("Teste de cadastro de medicamentos")
    void testCadastroMedicamento() {
        Medicamento medicamento = new Medicamento(1L, "Dorflex", Administracao.ORAL, new ArrayList<>(List.of("dor")),
                new ArrayList<>(List.of("dengue")));

        util.cadastrarMedicamento(medicamento);

        List<Medicamento> medicamentos = util.buscarMedicamentos();

        Assertions.assertFalse(medicamentos.isEmpty());
        Assertions.assertEquals("Dorflex", medicamentos.get(0).getNome());
        Assertions.assertEquals(List.of(medicamento), medicamentos);
    }

    @Test
    @DisplayName("Teste de cadastro de pessoas")
    void testCadastroPessoa() {
        Pessoa pessoa = new Pessoa(1L, "Renan", "dor", new ArrayList<>(List.of("dengue")), new ArrayList<>());

        util.cadastrarPessoa(pessoa);

        List<Pessoa> pessoas = util.buscarPessoas();

        Assertions.assertFalse(pessoas.isEmpty());
        Assertions.assertEquals("Renan", pessoas.get(0).getNome());
        Assertions.assertEquals(List.of(pessoa), pessoas);
    }

    @Test
    @DisplayName("Teste para prescricao do medicamento")
    void testPrecriscaoMedicamento() {
        Medicamento medicamento = new Medicamento(1L, "Dorflex", Administracao.ORAL, new ArrayList<>(List.of("dor")),
                new ArrayList<>(List.of("dengue")));
        util.cadastrarMedicamento(medicamento);

        Pessoa pessoa = new Pessoa(1L, "Renan", "dor", new ArrayList<>(List.of("sinusite")), new ArrayList<>());
        util.cadastrarPessoa(pessoa);

        util.prescricaoDeMedicamento(pessoa, medicamento);

        List<Pessoa> pessoas = util.buscarPessoas();

        Assertions.assertFalse(pessoas.isEmpty());
        Assertions.assertEquals("Renan", pessoas.get(0).getNome());
        Assertions.assertEquals(List.of(pessoa), pessoas);
        Assertions.assertEquals(List.of(medicamento), pessoas.get(0).getMedicamentos());
    }

    @Test
    void testPrecriscaoMedicamentoThrow() {
        Medicamento medicamento = new Medicamento(1L, "Dorflex", Administracao.ORAL, new ArrayList<>(List.of("dor")),
                new ArrayList<>(List.of("dengue")));
        util.cadastrarMedicamento(medicamento);

        Pessoa pessoa = new Pessoa(1L, "Renan", "dor", new ArrayList<>(List.of("dengue")), new ArrayList<>());
        util.cadastrarPessoa(pessoa);

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class,
                () -> util.prescricaoDeMedicamento(pessoa, medicamento));
        Assertions.assertEquals("Pessoa alérgica ao medicamento.", thrown.getMessage());
    }

}
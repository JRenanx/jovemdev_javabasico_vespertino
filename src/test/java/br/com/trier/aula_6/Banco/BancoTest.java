package br.com.trier.aula_6.Banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BancoTest {

    Caixa caixa = new Caixa();

    @BeforeEach
    void setUp() {
        caixa.limpaTudo();

        ContaCorrente corrente1 = new ContaCorrente(123, "390", "Ronaldo", 1000);
        ContaEspecial especial1 = new ContaEspecial(321, "431", "Juninho", 1000);
        ContaUniversitaria universitaria1 = new ContaUniversitaria(456, "431", "Kleber", 1000);

        caixa.getContas().add(corrente1);
        caixa.getContas().add(especial1);
        caixa.getContas().add(universitaria1);

        ContaCorrente corrente2 = new ContaCorrente(123, "431", "Bob", 1000);
        ContaEspecial especial2 = new ContaEspecial(321, "431", "Bob", 1000);
        ContaUniversitaria universitaria2 = new ContaUniversitaria(456, "EI", "Bob", 1000);

        caixa.getContas().add(corrente2);
        caixa.getContas().add(especial2);
        caixa.getContas().add(universitaria2);
    }

    @Test
    @DisplayName("Teste cadastra conta corrente")
    void cadastraContaCorrente() {
        ContaCorrente corrente2 = new ContaCorrente(1234, "C2", "Bob", 1000);
        caixa.cadastraContaCorrente(corrente2);
        assertEquals(7, caixa.getContas().size());
    }

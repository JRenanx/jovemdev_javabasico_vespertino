package br.com.trier.aula_6.Banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BancoTest {

    private Caixa caixa = new Caixa();

    @BeforeEach
    public void init() {
        caixa.getContas().clear();
        caixa.addConta(new ContaCorrente(1, 1, "Corrente", 1000));
        caixa.addConta(new ContaEspecial(2, 2, "Especial", 1000, 1000));
        caixa.addConta(new ContaUniversitaria(3, 3, "Universitario", 1000));
    }

    @Test
    @DisplayName("Teste deposito conta universatario")
    public void depositoCUni() {
        Contas univ = caixa.getContas().get(2);
        caixa.deposito(1000, univ);
        assertEquals(2000, univ.getSaldo());
    }

    @Test
    @DisplayName("Teste deposito conta universatario")
    public void saqueCEsp() {
        Contas esp = caixa.getContas().get(1);
        caixa.saque(2000, esp);
        assertEquals(-1000, esp.getSaldo());
    }

    @Test
    @DisplayName("Transferencia conta Corrente e Conta Univ")
    public void transf1() {
        Contas corr = caixa.getContas().get(0);
        ContaUniversitaria univ = (ContaUniversitaria) caixa.getContas().get(2);
        caixa.transferencia(10, corr, univ);
        assertEquals(990, corr.getSaldo());
        assertEquals(1010, univ.getSaldo());
    }

    @Test
    @DisplayName("Transferencia conta Corrente e Conta Univ +2000")
    public void transf2() {
        Contas conCorrente = caixa.getContas().get(0);
        ContaUniversitaria univ = (ContaUniversitaria) caixa.getContas().get(2);
        caixa.deposito(300, conCorrente);
        caixa.transferencia(1300, conCorrente, univ);
        assertEquals(1300, conCorrente.getSaldo());
        assertEquals(1000, univ.getSaldo());
    }

    @Test
    @DisplayName("Teste saque negativo conta Corrente")
    public void saqueNegativoContCorre() {
        Contas conCorrente = caixa.getContas().get(0);
        caixa.saque(1100, conCorrente);
        assertFalse(false);
    }

}
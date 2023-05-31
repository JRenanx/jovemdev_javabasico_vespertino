package br.com.trier.aula_5;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.desktop.AppReopenedEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicoTest {

    private Medico medico = new Medico();

    @BeforeEach
    public void init() {

        medico.getMedicamentos().clear();
        medico.getPessoas().clear();
        
        Pessoa p1 = new Pessoa("Tchola", "Gripe");
        p1.addCondicacaoSaude("Dengue");
        p1.addCondicacaoSaude("Diabetes");

        Pessoa p2 = new Pessoa("By Tola", "Dor");

        medico.cadastraPessoa(p1);
        medico.cadastraPessoa(p2);

        Medicamento m1 = new Medicamento("Med 1");
        m1.addIndicacao("Dor");
        m1.contraIndicacao("Pressão alta");
        Medicamento m2 = new Medicamento("Med 2");
        m2.addIndicacao("Gripe");
        m2.addIndicacao("Febre");
        m2.contraIndicacao("Dengue");
        Medicamento m3 = new Medicamento("Med 3");
        m3.addIndicacao("Gripe");
        
        medico.cadastraMedicamento(m1);
        medico.cadastraMedicamento(m2);
        medico.cadastraMedicamento(m3);
    }

    
    @Test
    void prescreverOK() {
        Pessoa p = medico.getPessoas().get(0);
        Medicamento m = medico.getMedicamentos().get(2);
        boolean prescrito = medico.prescreveMedicamento(p, m);
        assertEquals(true, prescrito);
        assertEquals(1, p.getMedicamentos().size());
        assertEquals("Med 3", p.getMedicamentos().get(0).getNome());
    }
    
    @Test
    void prescreverFalhaIndicacao(){
        Pessoa p = medico.getPessoas().get(0);
        Medicamento m = medico.medicamentos.get(0);
        boolean prescrito = medico.prescreveMedicamento(p, m);
        assertEquals(false, prescrito);
        assertEquals(0, p.getMedicamentos().size());
    }
    
    


}

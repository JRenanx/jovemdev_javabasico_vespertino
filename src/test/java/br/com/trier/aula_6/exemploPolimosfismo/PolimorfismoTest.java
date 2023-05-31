package br.com.trier.aula_6.exemploPolimosfismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PolimorfismoTest {

    private List<Forma> lista = new ArrayList<Forma>();

    @BeforeEach
    public void init() {
        lista.add(new Circulo(3));
        lista.add(new Cone());
        lista.add(new Quadrado());
        lista.add(new Triangulo());
    }

    @Test
    @DisplayName("Teste Desenhar Circulo")
    public void desenharCirculoTest() {
        String s = lista.get(0).desenhar();
        assertEquals("Desenhando um Circulo", s);
    }

    @Test
    @DisplayName("Teste area circulo")
    public void areaCirculoTest() {
        Circulo c = (Circulo) lista.get(0);
        double area = c.calculaArea();
        DecimalFormat df = new DecimalFormat("##.00");
        assertEquals("28,27", df.format(area));
    }

    @Test
    @DisplayName("Teste Desenhar Cone")
    public void desenharConeTest() {
        String s = lista.get(1).desenhar();
        assertEquals("Desenhando um Cone", s);
    }
    
    @Test
    @DisplayName("Teste Desenhar Quadrado")
    public void desenharQuadradoTest() {
        String s = lista.get(2).desenhar();
        assertEquals("Desenhando um Quadrado com 4 lados", s);
    }
    
    @Test
    @DisplayName("Teste Desenhar Triangulo")
    public void desenharTrianguloTest() {
        String s = lista.get(3).desenhar();
        assertEquals("Desenhando um Triângulo com 3 lados", s);
    }
}

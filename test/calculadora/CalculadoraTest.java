package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @Test
    public void testSoma() {
        assertEquals(9, calc.soma(4, 5));
    }

    @Test
    public void testSubtracao() {
        assertEquals(5, calc.subtracao(10, 5));
    }

    @Test
    public void testMultiplicacao() {
        assertEquals(20, calc.multiplicacao(4, 5));
    }

    @Test
    public void testDivisao() {
        assertEquals(2, calc.divisao(8, 4));
    }

    @Test
    public void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @Test
    public void testSomatoria() {
        assertEquals(15, calc.somatoria(5));
    }

    @Test
    public void testNumeroPositivo() {
        assertTrue(calc.ehPositivo(10));
    }

    @Test
    public void testNumeroNegativo() {
        assertFalse(calc.ehPositivo(-10));
    }

    @Test
    public void testComparaIguais() {
        assertEquals(0, calc.compara(5, 5));
    }

    @Test
    public void testComparaPrimeiroMaior() {
        assertEquals(1, calc.compara(10, 5));
    }

    @Test
    public void testComparaPrimeiroMenor() {
        assertEquals(-1, calc.compara(5, 10));
    }
}
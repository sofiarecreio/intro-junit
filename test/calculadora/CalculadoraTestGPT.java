package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTestGPT {

    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    // =========================
    // Testes de soma
    // =========================

    @Test
    public void deveSomarDoisNumerosPositivos() {
        assertEquals(8, calculadora.soma(3, 5));
    }

    @Test
    public void deveSomarNumerosNegativos() {
        assertEquals(-8, calculadora.soma(-3, -5));
    }

    @Test
    public void deveSomarNumeroPositivoComNegativo() {
        assertEquals(2, calculadora.soma(5, -3));
    }

    @Test
    public void deveSomarComZero() {
        assertEquals(5, calculadora.soma(5, 0));
    }

    // =========================
    // Testes de subtração
    // =========================

    @Test
    public void deveSubtrairDoisNumerosPositivos() {
        assertEquals(2, calculadora.subtracao(5, 3));
    }

    @Test
    public void deveSubtrairNumerosNegativos() {
        assertEquals(2, calculadora.subtracao(-3, -5));
    }

    @Test
    public void deveRetornarResultadoNegativoNaSubtracao() {
        assertEquals(-2, calculadora.subtracao(3, 5));
    }

    @Test
    public void deveSubtrairComZero() {
        assertEquals(5, calculadora.subtracao(5, 0));
    }

    // =========================
    // Testes de multiplicação
    // =========================

    @Test
    public void deveMultiplicarDoisNumerosPositivos() {
        assertEquals(15, calculadora.multiplicacao(3, 5));
    }

    @Test
    public void deveMultiplicarDoisNumerosNegativos() {
        assertEquals(15, calculadora.multiplicacao(-3, -5));
    }

    @Test
    public void deveMultiplicarNumeroPositivoPorNegativo() {
        assertEquals(-15, calculadora.multiplicacao(3, -5));
    }

    @Test
    public void deveRetornarZeroQuandoMultiplicarPorZero() {
        assertEquals(0, calculadora.multiplicacao(10, 0));
    }

    // =========================
    // Testes de divisão
    // =========================

    @Test
    public void deveDividirDoisNumerosInteiros() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    public void deveRealizarDivisaoInteira() {
        assertEquals(2, calculadora.divisao(5, 2));
    }

    @Test
    public void deveDividirNumerosNegativos() {
        assertEquals(2, calculadora.divisao(-10, -5));
    }

    @Test
    public void deveRetornarResultadoNegativoNaDivisao() {
        assertEquals(-2, calculadora.divisao(10, -5));
    }

    @Test
    public void deveLancarExcecaoAoDividirPorZero() {
        org.junit.jupiter.api.Assertions.assertThrows(
            ArithmeticException.class,
            () -> calculadora.divisao(10, 0)
        );
    }

    // =========================
    // Testes de somatória
    // =========================

    @Test
    public void deveCalcularSomatoriaAteZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    public void deveCalcularSomatoriaDeUm() {
        assertEquals(1, calculadora.somatoria(1));
    }

    @Test
    public void deveCalcularSomatoriaDeCinco() {
        assertEquals(15, calculadora.somatoria(5));
    }

    @Test
    public void deveCalcularSomatoriaDeDez() {
        assertEquals(55, calculadora.somatoria(10));
    }

    @Test
    public void deveRetornarZeroParaNumeroNegativo() {
        assertEquals(0, calculadora.somatoria(-1));
    }

    // =========================
    // Testes de ehPositivo
    // =========================

    @Test
    public void zeroDeveSerConsideradoPositivo() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    public void numeroPositivoDeveRetornarTrue() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    public void numeroNegativoDeveRetornarFalse() {
        assertFalse(calculadora.ehPositivo(-10));
    }

    // =========================
    // Testes de comparação
    // =========================

    @Test
    public void deveRetornarZeroQuandoNumerosForemIguais() {
        assertEquals(0, calculadora.compara(5, 5));
    }

    @Test
    public void deveRetornarUmQuandoPrimeiroNumeroForMaior() {
        assertEquals(1, calculadora.compara(10, 5));
    }

    @Test
    public void deveRetornarMenosUmQuandoPrimeiroNumeroForMenor() {
        assertEquals(-1, calculadora.compara(5, 10));
    }

    @Test
    public void deveCompararNumerosNegativosIguais() {
        assertEquals(0, calculadora.compara(-5, -5));
    }

    @Test
    public void deveRetornarUmAoCompararNegativos() {
        assertEquals(1, calculadora.compara(-3, -5));
    }

    @Test
    public void deveRetornarMenosUmAoCompararNegativos() {
        assertEquals(-1, calculadora.compara(-5, -3));
    }
}



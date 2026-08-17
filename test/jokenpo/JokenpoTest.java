package jokenpo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JokenpoTest {
    private Jokenpo jokenpo;

    @BeforeEach
    public void setUp() {
        jokenpo = new Jokenpo();
    }

    @Test
    public void deveEmpatarPapelContraPapel() {
        assertEquals(0, jokenpo.jogar(1, 1));
    }

    @Test
    public void deveEmpatarPedraContraPedra() {
        assertEquals(0, jokenpo.jogar(2, 2));
    }

    @Test
    public void deveEmpatarTesouraContraTesoura() {
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    @Test
    public void jogador1VenceComPapelContraPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    public void jogador1VenceComPedraContraTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    public void jogador1VenceComTesouraContraPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    @Test
    public void jogador2VenceComPedraContraPapel() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    public void jogador2VenceComTesouraContraPedra() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    public void jogador2VenceComPapelContraTesoura() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    @Test
    public void retornaMenosUmQuandoJogador1EscolheZero() {
        assertEquals(-1, jokenpo.jogar(0, 1));
    }

    @Test
    public void retornaMenosUmQuandoJogador1EscolheValorNegativo() {
        assertEquals(-1, jokenpo.jogar(-1, 1));
    }

    @Test
    public void retornaMenosUmQuandoJogador1EscolheValorMaiorQueTres() {
        assertEquals(-1, jokenpo.jogar(4, 1));
    }

    @Test
    public void retornaMenosUmQuandoJogador2EscolheZero() {
        assertEquals(-1, jokenpo.jogar(1, 0));
    }

    @Test
    public void retornaMenosUmQuandoJogador2EscolheValorNegativo() {
        assertEquals(-1, jokenpo.jogar(1, -1));
    }

    @Test
    public void retornaMenosUmQuandoJogador2EscolheValorMaiorQueTres() {
        assertEquals(-1, jokenpo.jogar(1, 4));
    }

    @Test
    public void retornaMenosUmQuandoAmbosEscolhemValoresInvalidos() {
        assertEquals(-1, jokenpo.jogar(0, 4));
    }
}

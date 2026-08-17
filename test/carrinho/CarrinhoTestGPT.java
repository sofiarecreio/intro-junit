package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Livro", 50.0);
        produto2 = new Produto("Caderno", 20.0);
    }

    @Test
    @DisplayName("Deve iniciar o carrinho com quantidade zero e valor total zero")
    void testCarrinhoInicialmenteVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Deve adicionar um item e atualizar a quantidade e o valor total")
    void testAddItem() {
        carrinho.addItem(produto1);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(50.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Deve somar corretamente o valor total com múltiplos itens")
    void testGetValorTotalComMultiplosItens() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(70.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Deve remover um item existente com sucesso")
    void testRemoveItemComSucesso() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }

    @Test
    @DisplayName("Deve lançar ProdutoNaoEncontradoException ao tentar remover item inexistente")
    void testRemoveItemInexistenteLancaExcecao() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto1));
    }

    @Test
    @DisplayName("Deve zerar a quantidade de itens e valor total ao esvaziar o carrinho")
    void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.0001);
    }
}
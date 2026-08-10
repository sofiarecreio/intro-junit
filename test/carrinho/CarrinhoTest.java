package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();

        produto1 = new Produto("Teclado", 100.0);
        produto2 = new Produto("Mouse", 50.0);
    }

    @Test
    public void testCarrinhoInicialVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testAdicionarItem() {
        carrinho.addItem(produto1);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testAdicionarDoisItens() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    public void testValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(150.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testRemoverItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);

        carrinho.removeItem(produto1);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testRemoverItemInexistente() {
        assertThrows(
            ProdutoNaoEncontradoException.class,
            () -> carrinho.removeItem(produto1)
        );
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }
}
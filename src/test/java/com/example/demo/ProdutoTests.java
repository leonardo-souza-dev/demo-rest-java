package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTests {

    @Test
    public void deveInserirProduto() throws Exception {
		
        // arrange
        String nomeProduto = "TV";
        BigDecimal preco = new BigDecimal(3999);
        
        ProdutoRepository repository = new ProdutoRepository();
        Logger logger = new Logger();
        ProdutoService service = new ProdutoService(repository, logger);
        ProdutoController controller = new ProdutoController(service);

        // act
        ProdutoResponse response = controller.inserirProduto(nomeProduto, preco);

        // assert
        assertNotNull(response);
        assertNotNull(response.getProduto());
        assertEquals(nomeProduto, response.getProduto().getNome());
        assertEquals(preco, response.getProduto().getPreco());
        assertTrue(response.getSucesso());
        assertEquals("Produto inserido com sucesso", response.getMensagem());
    }
}

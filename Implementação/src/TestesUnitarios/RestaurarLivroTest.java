package TestesUnitarios;

import controller.LivroController;
import model.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurarLivroTest {

    private LivroController livroController;

    @BeforeEach
    public void setUp() {
        livroController = LivroController.getInstance();
    }

    @Test
    public void testRestaurarLivroComSucesso() {
        // Seleciona um livro para restauração
        List<Livro> livros = livroController.getLivros();
        Livro livroParaRestaurar = livros.get(2); // Livro com ID 3

        // Tenta restaurar o livro
        assertTrue(livroController.restaurarLivro(livroParaRestaurar.getId()));

        // Verifica se o estado do livro foi alterado para "Restauração em andamento"
        Livro livroRestaurando = livroController.getLivros().get(2); // Livro com ID 3
        assertEquals("Restauração em andamento", livroRestaurando.getEstado());
    }

    @Test
    public void testRestaurarLivroInexistente() {
        // Tenta restaurar um livro com ID inexistente
        assertFalse(livroController.restaurarLivro(10)); // ID inexistente

        // Verifica se nenhum livro foi alterado
        List<Livro> livros = livroController.getLivros();
        for (Livro livro : livros) {
            assertNotEquals("Restauração em andamento", livro.getEstado());
        }
    }

    @Test
    public void testRestaurarLivroEstadoInicial() {
        // Verifica se o estado inicial de todos os livros é correto
        List<Livro> livros = livroController.getLivros();
        for (Livro livro : livros) {
            assertNotEquals("Restauração em andamento", livro.getEstado());
        }
    }
}

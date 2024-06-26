package TestesUnitarios;

import controller.LivroController;
import controller.ReservaController;
import model.Livro;
import model.Reserva;
import model.Socio;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinhasReservasApagarTest {

    private LivroController livroController;
    private Socio socio1;
    private Socio socio2;

    @Before
    public void setUp() {
        livroController = new LivroController();
        socio1 = new Socio("João", "111111111", "999999999", "Rua A", "joao@gmail.com", "SMS", "Maria", "Premium");
        socio2 = new Socio("Maria", "222222222", "888888888", "Rua B", "maria@gmail.com", "Email", "João", "Regular");
    }
    @Test
    public void testAdicionarSocioListaEspera() {
        Livro livro = livroController.getLivros().get(0); // Pegando o primeiro livro da lista para teste
      //  assertTrue(livroController.adicionarSocioListaEspera(livro.getId(), socio1));

        List<Reserva> reservas = ReservaController.getInstance().getReservasByLivroId(livro.getId());
        assertEquals(1, reservas.size());
        assertEquals(livro, reservas.get(0).getLivro());
    }

    public void testRemoverSocioListaEspera() {
        Livro livro = livroController.getLivros().get(1); // Pegando o segundo livro da lista para teste
       // livroController.adicionarSocioListaEspera(livro.getId(), socio1);
      //  livroController.adicionarSocioListaEspera(livro.getId(), socio2);

   //     assertTrue(livroController.removerSocioListaEspera(livro.getId(), socio1));
      //  assertFalse(livroController.getLivros().get(1).getListaEspera().contains(socio1));
    }


}

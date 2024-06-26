package TestesUnitarios;

import model.Livro;
import model.Reserva;
import model.Socio;
import controller.ReservaController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListaEsperaTest {

    private ReservaController reservaController;

    @Test
    public void testAdicionarListaEspera() {
        Socio socio1 = new Socio("Guilherme", "243754171", "969418291", "Rua do Forno", "guilherme@gmail", "SMS", "Joao", "Premium");
        Livro livro = new Livro(1, "Piratas", "Novo", "Fernando", 2);
        Reserva reserva = new Reserva( livro,socio1.getId(),"Joao");

    //    reservaController.(reserva);

        List<Reserva> listaEspera = reservaController.getReservasByLivroId(livro.getId());

        assertEquals(1, listaEspera.size());
        assertTrue(listaEspera.contains(reserva));
      //  assertTrue(reserva.isEmListaDeEspera());
    }
    @Test
    public void testRemoverListaEspera() {
        Socio socio1 = new Socio("Guilherme", "243754171", "969418291", "Rua do Forno", "guilherme@gmail", "SMS", "Joao", "Premium");
        Livro livro = new Livro(1, "Piratas", "Novo", "Fernando", 2);
     //   Reserva reserva = new Reserva(socio1.getId(), livro, true); // Inicia como lista de espera

       // reservaController.adicionarListaEspera(reserva);

     //   List<Reserva> listaEsperaInicial = reservaController.getListaEsperaByLivroId(livro.getId());
      //  assertEquals(1, listaEsperaInicial.size());

    //    reservaController.removerListaEspera(reserva);

     //   List<Reserva> listaEsperaFinal = reservaController.getListaEsperaByLivroId(livro.getId());
      //  assertEquals(0, listaEsperaFinal.size());
    //    assertFalse(reserva.isEmListaDeEspera());
    }
}



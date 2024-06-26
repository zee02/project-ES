package TestesUnitarios;

import controller.SocioController;
import model.Socio;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListaSocioTest {

    private SocioController socioController;

    public void setUp() {
        socioController = SocioController.getInstance();
        // Adicionar alguns sócios para testar getAllSocios
        Socio socio1 = new Socio("Rute", "12345678", "969418292","Rua do beco","guilherme@gmail","SMS","Joao","Premium");
        Socio socio2 = new Socio("Maria", "12345628", "969418222","Rua do beco","guilherme@gmail","SMS","Joao","Premium");
        socioController.addSocio(socio1);
        socioController.addSocio(socio2);

    }
    public void ListaSocioTest()
    {
        List<Socio> socios = socioController.getAllSocios();
        assertNotNull(socios);
        assertEquals(2, socios.size());
        assertTrue(socios.stream().anyMatch(s -> s.getNome().equals("Rute")));
        assertTrue(socios.stream().anyMatch(s -> s.getNome().equals("Maria")));

    }
    }


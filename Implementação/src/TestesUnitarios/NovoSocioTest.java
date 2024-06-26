package TestesUnitarios;

import controller.SocioController;
import model.Socio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NovoSocioTest {

    private SocioController socioController;

    public void setUp() {
        socioController = SocioController.getInstance();
    }

    @Test
    public void testAddSocio() {
        Socio socio = new Socio("Guilherme", "243754171", "969418291","Rua do forno","guilherme@gmail","SMS","Joao","Premium");
        assertTrue(socioController.addSocio(socio));
    }
}



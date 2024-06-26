package TestesUnitarios;

import controller.SocioController;
import model.Socio;

import static org.junit.jupiter.api.Assertions.*;

public class EditarSocioTest {

    private SocioController socioController;

    public void setUp() {

    socioController = SocioController.getInstance();
    Socio socio = new Socio("Guilherme", "243754171", "969418291","Rua do forno","guilherme@gmail","SMS","Joao","Premium");

    socioController.addSocio(socio);


}
    public void testAtualizarSocio() {
        // Atualizar o sócio
        Socio socioAtualizado = new Socio("Rute", "12345678", "969418292","Rua do beco","guilherme@gmail","SMS","Joao","Premium");
        assertTrue(socioController.atualizarSocio(socioAtualizado));

        // Verificar se o sócio foi atualizado corretamente
        Socio socioObtido = socioController.getSocioById(2);
        assertNotNull(socioObtido);
        assertEquals("Rute", socioObtido.getNome());
        assertEquals("12345678", socioObtido.getNifCc());
        assertEquals("969418292", socioObtido.getTelefone());
        assertEquals("Rua do beco", socioObtido.getMorada());
        assertEquals("guilherme@gmail", socioObtido.getEmail());
        assertEquals("SMS", socioObtido.getTipoNotificacao());
        assertEquals("Joao", socioObtido.getFuncionario());
        assertEquals("Premium", socioObtido.getTipoSocio());

    }
}

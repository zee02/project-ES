package TestesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import controller.FuncionarioController;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ListarFuncionariosTest {

    private FuncionarioController funcionarioController;

    @BeforeEach
    public void setUp() {
        funcionarioController = new FuncionarioController();
    }

    @Test
    public void testListarFuncionarios() {
        String nome1 = "Funcionário 1";
        String nome2 = "Funcionário 2";
        String nome3 = "Funcionário 3";

        funcionarioController.criarFuncionario(nome1, 2000.0, "123456789", "Cargo 1");
        funcionarioController.criarFuncionario(nome2, 2500.0, "987654321", "Cargo 2");
        funcionarioController.criarFuncionario(nome3, 3000.0, "111111111", "Cargo 3");

        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();

        assertEquals(3, funcionarios.size(), "Número incorreto de funcionários na lista.");

        assertTrue(funcionarios.stream().anyMatch(funcionario -> funcionario.getNome().equals(nome1)),
                "Funcionário 1 não encontrado na lista.");
        assertTrue(funcionarios.stream().anyMatch(funcionario -> funcionario.getNome().equals(nome2)),
                "Funcionário 2 não encontrado na lista.");
        assertTrue(funcionarios.stream().anyMatch(funcionario -> funcionario.getNome().equals(nome3)),
                "Funcionário 3 não encontrado na lista.");
    }
}

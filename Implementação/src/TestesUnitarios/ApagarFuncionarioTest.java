package TestesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import controller.FuncionarioController;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApagarFuncionarioTest {

    private FuncionarioController funcionarioController;

    @BeforeEach
    public void setUp() {
        funcionarioController = new FuncionarioController();
    }

    @Test
    public void testApagarFuncionario() {
        String nome = "Funcionário para Apagar";
        double salario = 3000.0;
        String telefone = "987654321";
        String cargo = "Gerente";

        funcionarioController.criarFuncionario(nome, salario, telefone, cargo);

        funcionarioController.apagarFuncionario(nome);

        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();

        boolean funcionarioApagado = true;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionarioApagado = false;
                break;
            }
        }

        assertTrue(funcionarioApagado, "Funcionário não foi apagado corretamente.");
    }
}

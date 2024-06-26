package TestesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import controller.FuncionarioController;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CriarFuncionarioTest {

    private FuncionarioController funcionarioController;

    @BeforeEach
    public void setUp() {
        funcionarioController = new FuncionarioController();
    }

    @Test
    public void testCriarFuncionario() {
        String nome = "Teste";
        double salario = 2000.0;
        String telefone = "123456789";
        String cargo = "Analista";

        funcionarioController.criarFuncionario(nome, salario, telefone, cargo);

        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();

        boolean funcionarioEncontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome) &&
                    funcionario.getSalario() == salario &&
                    funcionario.getTelefone().equals(telefone) &&
                    funcionario.getCargo().equals(cargo)) {
                funcionarioEncontrado = true;
                break;
            }
        }

        assertTrue(funcionarioEncontrado, "Funcionário não foi criado corretamente.");
    }
}

package TestesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import controller.FuncionarioController;
import model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EditarFuncionarioTest {

    private FuncionarioController funcionarioController;

    @BeforeEach
    public void setUp() {
        funcionarioController = new FuncionarioController();
    }

    @Test
    public void testEditarFuncionario() {
        String nomeAntigo = "Funcionario Antigo";
        double salarioAntigo = 3000.0;
        String telefoneAntigo = "123456789";
        String cargoAntigo = "Analista";

        funcionarioController.criarFuncionario(nomeAntigo, salarioAntigo, telefoneAntigo, cargoAntigo);

        String nomeNovo = "Funcionario Novo";
        double salarioNovo = 3500.0;
        String telefoneNovo = "987654321";
        String cargoNovo = "Desenvolvedor";

        funcionarioController.editarFuncionario(nomeAntigo, salarioNovo, telefoneNovo, cargoNovo);

        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();

        boolean funcionarioEditado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nomeAntigo) &&
                    funcionario.getSalario() == salarioNovo &&
                    funcionario.getTelefone().equals(telefoneNovo) &&
                    funcionario.getCargo().equals(cargoNovo)) {
                funcionarioEditado = true;
                break;
            }
        }

        assertTrue(funcionarioEditado, "Funcionário não foi editado corretamente.");
    }
}

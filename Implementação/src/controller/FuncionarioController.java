package controller;

import model.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    public void criarFuncionario(String nome, double salario, String telefone, String cargo) {
        Random random = new Random();
        int pontos = random.nextInt(100); // Gerando pontos aleatórios entre 0 e 99
        Funcionario funcionario = new Funcionario(nome, salario, telefone, cargo, pontos);
        funcionarios.add(funcionario);
    }

    public void editarFuncionario(String nome, double salario, String telefone, String cargo) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                f.setSalario(salario);
                f.setTelefone(telefone);
                f.setCargo(cargo);
                return;
            }
        }
    }

    public void apagarFuncionario(String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public List<Funcionario> listarFuncionariosPorPontos() {
        List<Funcionario> copiaFuncionarios = new ArrayList<>(funcionarios);
        Collections.sort(copiaFuncionarios, (f1, f2) -> f2.getPontos() - f1.getPontos());
        return copiaFuncionarios;
    }

    public void adicionarPontos(String nome, int pontos) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                f.setPontos(f.getPontos() + pontos);
                return;
            }
        }
    }
}

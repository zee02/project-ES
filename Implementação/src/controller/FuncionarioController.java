package controller;

import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void criarFuncionario(String nome, double salario, String telefone, String cargo) {
        Funcionario funcionario = new Funcionario(nome, salario, telefone, cargo);
        funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public void editarFuncionario(String nome, double salario, String telefone, String cargo) {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            funcionario.setSalario(salario);
            funcionario.setTelefone(telefone);
            funcionario.setCargo(cargo);
        }
    }

    public void apagarFuncionario(String nome) {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        }
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}

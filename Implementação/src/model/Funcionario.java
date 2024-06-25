package model;

public class Funcionario {
    private String nome;
    private double salario;
    private String telefone;
    private String cargo;

    public Funcionario(String nome, double salario, String telefone, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    // Getters and Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}

package model;

public class Funcionario {
    private String nome;
    private double salario;
    private String telefone;
    private String cargo;
    private int pontos; // Adicionando o campo pontos

    public Funcionario(String nome, double salario, String telefone, String cargo, int pontos) {
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
        this.cargo = cargo;
        this.pontos = pontos;
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

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }
}

package model;

public class Socio {
    private static int currentId = 0; // Usado para gerar IDs únicos
    private int id;
    private String nome;
    private String nifCc;
    private String telefone;
    private String morada;
    private String email;
    private String tipoNotificacao;
    private String funcionario;
    private String tipoSocio;

    public Socio(String nome, String nifCc, String telefone, String morada, String email, String tipoNotificacao, String funcionario, String tipoSocio) {
        this.id = ++currentId; // Incrementa o ID único para cada novo sócio
        this.nome = nome;
        this.nifCc = nifCc;
        this.telefone = telefone;
        this.morada = morada;
        this.email = email;
        this.tipoNotificacao = tipoNotificacao;
        this.funcionario = funcionario;
        this.tipoSocio = tipoSocio;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNifCc() {
        return nifCc;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getMorada() {
        return morada;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoNotificacao() {
        return tipoNotificacao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getTipoSocio() {
        return tipoSocio;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNifCc(String nifCc) {
        this.nifCc = nifCc;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoNotificacao(String tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }
}

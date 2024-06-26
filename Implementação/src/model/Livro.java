package model;

public class Livro {
    private String id;
    private String nome;
    private String estado;

    public Livro(String id, String nome, String estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nome do Livro: " + nome + ", id='" + id + "', estado='" + estado + "'";
    }
}

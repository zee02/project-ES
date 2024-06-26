package model;

public class Livro {
    private int id;
    private String nome;
    private String estado;

    private int numeroPessoasEspera;
    private String autor;

    public Livro(int id, String nome, String estado,String autor,int numeroPessoasEspera) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.autor = autor;
        this.numeroPessoasEspera = numeroPessoasEspera;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public String getAutor() {
        return autor;

    }
    public int getNumeroPessoasEspera() {
        return numeroPessoasEspera;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nome do Livro: " + nome + ", id='" + id + "', estado='" + estado + "'";
    }
}

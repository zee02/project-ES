package model;

public class Reserva {
    private String idSocio;
    private String tituloLivro;
    private String autorLivro;
    private int numPessoasListaEspera;

    // Construtor
    public Reserva(String idSocio, String tituloLivro, String autorLivro, int numPessoasListaEspera) {
        this.idSocio = idSocio;
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.numPessoasListaEspera = numPessoasListaEspera;
    }

    // Getters e Setters
    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public int getNumPessoasListaEspera() {
        return numPessoasListaEspera;
    }

    public void setNumPessoasListaEspera(int numPessoasListaEspera) {
        this.numPessoasListaEspera = numPessoasListaEspera;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idSocio='" + idSocio + '\'' +
                ", tituloLivro='" + tituloLivro + '\'' +
                ", autorLivro='" + autorLivro + '\'' +
                ", numPessoasListaEspera=" + numPessoasListaEspera +
                '}';
    }
}

package model;
public class Livro {
    private String id;
    private String estado;

    public Livro(String id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

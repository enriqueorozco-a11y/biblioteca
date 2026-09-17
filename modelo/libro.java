package modelo;

public abstract class Libro {
    private int id;
    private String titulo;
    private boolean disponible;

    public Libro() { this.disponible = true; }
    public Libro(int id, String titulo) { this.id=id; this.titulo=titulo; this.disponible=true; }
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getTitulo(){ return titulo; }
    public void setTitulo(String titulo){ this.titulo=titulo; }
    public boolean isDisponible(){ return disponible; }
    public void setDisponible(boolean disponible){ this.disponible=disponible; }
    public boolean prestar(){ if(!disponible) return false; disponible=false; return true; }
    public void devolver(){ disponible=true; }
    public abstract String obtenerDescripcion();
    public String obtenerDescripcion(String detalle){ return obtenerDescripcion()+" | "+detalle; } // sobrecarga
    @Override public String toString(){ return obtenerDescripcion(); }
}
package modelo;

public class LibroFisico extends Libro {
    private String ubicacion;
    private int numeroPaginas;
    public LibroFisico(){ super(); }
    public LibroFisico(int id,String titulo,String ubicacion,int numeroPaginas){ super(id,titulo); this.ubicacion=ubicacion; this.numeroPaginas=numeroPaginas; }
    public String getUbicacion(){ return ubicacion; }
    public void setUbicacion(String ubicacion){ this.ubicacion=ubicacion; }
    public int getNumeroPaginas(){ return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas){ this.numeroPaginas=numeroPaginas; }
    @Override public String obtenerDescripcion(){ return "Libro físico: "+getTitulo()+" | Ubicación: "+ubicacion+" | Páginas: "+numeroPaginas+" | Disponible: "+isDisponible(); }
    public double calcularMulta(int dias){ return Math.max(0,dias)*1000.0; }
}

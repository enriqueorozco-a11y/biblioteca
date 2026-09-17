package modelo;

public class LibroDigital extends Libro {
    private String formato;
    private double tamanoMB;
    private String enlaceDescarga;
    public LibroDigital(){ super(); }
    public LibroDigital(int id,String titulo,String formato,double tamanoMB){ super(id,titulo); this.formato=formato; this.tamanoMB=tamanoMB; }
    public String getFormato(){ return formato; }
    public void setFormato(String formato){ this.formato=formato; }
    public double getTamanoMB(){ return tamanoMB; }
    public void setTamanoMB(double tamanoMB){ this.tamanoMB=tamanoMB; }
    public String getEnlaceDescarga(){ return enlaceDescarga; }
    public void setEnlaceDescarga(String enlaceDescarga){ this.enlaceDescarga=enlaceDescarga; }
    @Override public String obtenerDescripcion(){ return "Libro digital: "+getTitulo()+" | Formato: "+formato+" | Tamaño: "+tamanoMB+" MB | Disponible: "+isDisponible(); }
    public String generarAcceso(){ return enlaceDescarga==null?"Acceso no configurado":enlaceDescarga; }
}

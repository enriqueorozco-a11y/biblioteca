package biblioteca.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private List<Prestamo> prestamos;
    public Usuario(){ prestamos=new ArrayList<>(); }
    public Usuario(int id,String nombre,String correo){ this.id=id; this.nombre=nombre; this.correo=correo; prestamos=new ArrayList<>(); }
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre=nombre; }
    public String getCorreo(){ return correo; }
    public void setCorreo(String correo){ this.correo=correo; }
    public List<Prestamo> getPrestamos(){ return Collections.unmodifiableList(prestamos); }
    public Prestamo solicitarPrestamo(Libro libro){ if(libro==null) throw new IllegalArgumentException("El libro no puede ser nulo."); Prestamo p=new Prestamo(prestamos.size()+1,libro); if (p.iniciar()) { prestamos.add(p); return p; } return null; }
    public void devolverPrestamo(Prestamo prestamo){ if(prestamo!=null&&prestamos.contains(prestamo)) prestamo.registrarDevolucion(); }
}
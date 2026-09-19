package modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autor {
    private int id;
    private String nombre;
    private String nacionalidad;
    private List<Libro> libros;
    public Autor(){ libros=new ArrayList<>(); }
    public Autor(int id,String nombre,String nacionalidad){ this.id=id; this.nombre=nombre; this.nacionalidad=nacionalidad; libros=new ArrayList<>(); }
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre=nombre; }
    public String getNacionalidad(){ return nacionalidad; }
    public void setNacionalidad(String nacionalidad){ this.nacionalidad=nacionalidad; }
    public List<Libro> getLibros(){ return Collections.unmodifiableList(libros); }
    public void setLibros(List<Libro> libros){ this.libros=new ArrayList<>(libros); }
    public void agregarLibro(Libro libro){ if(libro!=null&&!libros.contains(libro)) libros.add(libro); }
    public void eliminarLibro(Libro libro){ libros.remove(libro); }
    public List<Libro> listarLibros(){ return getLibros(); }
}
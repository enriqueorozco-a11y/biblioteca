package servicio;
import biblioteca.modelo.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorBiblioteca {
    private final List<Libro> libros=new ArrayList<>();
    private final List<Autor> autores=new ArrayList<>();
    private final List<Usuario> usuarios=new ArrayList<>();
    public void registrarLibro(Libro l){ if(l!=null) libros.add(l); }
    public void registrarAutor(Autor a){ if(a!=null) autores.add(a); }
    public void registrarUsuario(Usuario u){ if(u!=null) usuarios.add(u); }
    public List<Libro> getLibros(){ return Collections.unmodifiableList(libros); }
    public List<Autor> getAutores(){ return Collections.unmodifiableList(autores); }
    public List<Usuario> getUsuarios(){ return Collections.unmodifiableList(usuarios); }
}
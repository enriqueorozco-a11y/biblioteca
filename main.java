

import modelo.*;
import servicio.GestorBiblioteca;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("       SISTEMA DE BIBLIOTECA - JAVA");
        System.out.println("==============================================");
        GestorBiblioteca biblioteca=new GestorBiblioteca();
        Autor autor1=new Autor(1,"Gabriel Garcia Marquez","Colombiana");
        Autor autor2=new Autor(2,"George Orwell","Britanica");
        biblioteca.registrarAutor(autor1); biblioteca.registrarAutor(autor2);
        Libro libroFisico=new LibroFisico(101,"Cien anos de soledad","Estante A-10",471);
        Libro libroDigital=new LibroDigital(102,"1984","PDF",2.5);
        ((LibroDigital)libroDigital).setEnlaceDescarga("https://biblioteca.local/1984");
        autor1.agregarLibro(libroFisico); autor2.agregarLibro(libroDigital);
        biblioteca.registrarLibro(libroFisico); biblioteca.registrarLibro(libroDigital);
        Usuario usuario=new Usuario(501,"Carlos Perez","carlos@correo.com"); biblioteca.registrarUsuario(usuario);
        System.out.println("\n--- LIBROS REGISTRADOS ---");
        for(Libro l:biblioteca.getLibros()) System.out.println(l.obtenerDescripcion());
        System.out.println("\n--- POLIMORFISMO ---");
        for(Libro l:Arrays.asList(libroFisico,libroDigital)) System.out.println(l.obtenerDescripcion());
        System.out.println("\n--- SOBRECARGA ---");
        System.out.println(libroFisico.obtenerDescripcion("Consulta general"));
        System.out.println(libroFisico.obtenerDescripcion("Consulta detallada"));
        System.out.println("\n--- PRESTAMO ---");
        Prestamo prestamo=usuario.solicitarPrestamo(libroFisico);
        if(prestamo!=null){
            System.out.println("Prestamo creado: #"+prestamo.getId());
            System.out.println("Libro: "+prestamo.getLibro().getTitulo());
            System.out.println("Estado: "+prestamo.getEstado());
            System.out.println("Disponible durante el prestamo: "+prestamo.getLibro().isDisponible());
            System.out.println("Detalles del prestamo: "+prestamo.getDetalles().size());
            prestamo.registrarDevolucion();
            System.out.println("Estado despues de devolver: "+prestamo.getEstado());
            System.out.println("Libro disponible nuevamente: "+prestamo.getLibro().isDisponible());
        }
        System.out.println("\n--- ENCAPSULAMIENTO ---");
        LibroDigital digital = (LibroDigital) libroDigital; digital.setTamanoMB(3.0); System.out.println("Tamano actualizado con setter: "+digital.getTamanoMB()+" MB");
        System.out.println("\n--- MULTIPLICIDADES ---");
        System.out.println("Autores registrados: "+biblioteca.getAutores().size());
        System.out.println("Libros registrados: "+biblioteca.getLibros().size());
        System.out.println("Prestamos del usuario: "+usuario.getPrestamos().size());
        System.out.println("\nPrograma ejecutado correctamente.");
    }
}
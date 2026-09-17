package modelo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamo {
    private int id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;
    private final Libro libro;
    private final List<DetallePrestamo> detalles;

    public Prestamo(){ libro=null; detalles=new ArrayList<>(); }
    public Prestamo(int id,Libro libro){
        if(libro==null) throw new IllegalArgumentException("El préstamo necesita un libro.");
        this.id=id; this.libro=libro; this.estado=EstadoPrestamo.ACTIVO; detalles=new ArrayList<>();
        detalles.add(new DetallePrestamo(1,LocalDate.now()));
    }
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public LocalDate getFechaPrestamo(){ return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate f){ fechaPrestamo=f; }
    public LocalDate getFechaDevolucion(){ return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate f){ fechaDevolucion=f; }
    public EstadoPrestamo getEstado(){ return estado; }
    public void setEstado(EstadoPrestamo e){ estado=e; }
    public Libro getLibro(){ return libro; }
    public List<DetallePrestamo> getDetalles(){ return Collections.unmodifiableList(detalles); }
    public boolean iniciar(){ if(fechaPrestamo==null) fechaPrestamo=LocalDate.now(); if(libro.prestar()){ estado=EstadoPrestamo.ACTIVO; return true; } return false; }
    public void registrarDevolucion(){ registrarDevolucion(LocalDate.now()); } // sobrecarga
    public void registrarDevolucion(LocalDate fecha){ if(fecha==null) throw new IllegalArgumentException("La fecha no puede ser nula."); fechaDevolucion=fecha; estado=EstadoPrestamo.DEVUELTO; libro.devolver(); }
    public int calcularDias(){ LocalDate fin=fechaDevolucion!=null?fechaDevolucion:LocalDate.now(); return fechaPrestamo==null?0:(int)ChronoUnit.DAYS.between(fechaPrestamo,fin); }
    public double calcularMulta(int dias){ return Math.max(0,dias)*1000.0; }
    public boolean estaActivo(){ return estado==EstadoPrestamo.ACTIVO; }
}

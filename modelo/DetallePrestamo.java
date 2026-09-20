package biblioteca.modelo;
import java.time.LocalDate;

public class DetallePrestamo {
    private int id;
    private LocalDate fechaRegistro;
    private String observacion;
    public DetallePrestamo(){ fechaRegistro=LocalDate.now(); }
    public DetallePrestamo(int id,LocalDate fechaRegistro){ this.id=id; this.fechaRegistro=fechaRegistro; }
    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public LocalDate getFechaRegistro(){ return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro){ this.fechaRegistro=fechaRegistro; }
    public String getObservacion(){ return observacion; }
    public void setObservacion(String observacion){ this.observacion=observacion; }
    public void registrarObservacion(String texto){ this.observacion=texto; }
}

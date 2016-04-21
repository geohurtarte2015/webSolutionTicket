

package ojetos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="TICKET")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID_TICKET")
    private int idTicket;
    
    @Column(name="TITULO")
    private String titulo;
    
    @Column(name="FECHA")
    private String fecha;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_ANALISTA")
    private Analista analista;
  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVICIO")
    private Servicio servicio;

    @ManyToOne(optional = false)
    @JoinColumn(name="ID_IMPACTO")
    private Impacto impacto;

    @Column(name="FECHA_INICIO")    
    private String fechaInicio;
    
    
    private String fechaFin;
    private String descripcion;
    private String causa;
    private String solucion;
    private int idEstado;
    private int idSeguimiento;
    private int idRaiz;

   
    public int getIdTicket() {
        return idTicket;
    }

  
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   
    public String getFecha() {
        return fecha;
    }

   
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


 
    public int getIdServicios() {
        return idServicios;
    }

   
    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

  
    public int getIdImpacto() {
        return idImpacto;
    }

   
    public void setIdImpacto(int idImpacto) {
        this.idImpacto = idImpacto;
    }

    
    public String getFechaInicio() {
        return fechaInicio;
    }

    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

   
    public String getFechaFin() {
        return fechaFin;
    }

   
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public String getCausa() {
        return causa;
    }

  
    public void setCausa(String causa) {
        this.causa = causa;
    }

   
    public String getSolucion() {
        return solucion;
    }

   
    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    
    public int getIdEstado() {
        return idEstado;
    }

   
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

 
    public int getIdSeguimiento() {
        return idSeguimiento;
    }

 
    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

   
    public int getIdRaiz() {
        return idRaiz;
    }

   
    public void setIdRaiz(int idRaiz) {
        this.idRaiz = idRaiz;
    }
    
    
    
    
    
            
      
    
    
    
}



package ojetos;

import java.io.Serializable;
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
    
    @Column(name="FECHA_FIN")    
    private String fechaFin;       
    
    @Column(name="DESCRIPCION")    
    private String descripcion;
    
    @Column(name="CAUSA")
    private String causa;
    
    @Column(name="SOLUCION")
    private String solucion;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_ESTADO")
    private Estado estado;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SEGUIMIENTO")   
    private Seguimiento seguimiento;
   
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_RAIZ")
    private Raiz raiz;

   
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

    
    public Analista getAnalista() {
        return analista;
    }


    public void setAnalista(Analista analista) {
        this.analista = analista;
    }

   
    public Servicio getServicio() {
        return servicio;
    }

  
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

   
    public Impacto getImpacto() {
        return impacto;
    }

   
    public void setImpacto(Impacto impacto) {
        this.impacto = impacto;
    }

 
    public Estado getEstado() {
        return estado;
    }

  
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

   
    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

  
    public Raiz getRaiz() {
        return raiz;
    }

   void setRaiz(Raiz raiz) {
        this.raiz = raiz;
    }
    
    
    
    
    
            
      
    
    
    
}

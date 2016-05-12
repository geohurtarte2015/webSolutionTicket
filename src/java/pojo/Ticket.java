

package pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "TICKET")
public class Ticket {
 
    @Id
    @GeneratedValue
    @Column(name = "ID_TICKET")
    private int idTicket;
    
    @Column(name="TITULO")
    private String titulo;
    
    @Column(name="FECHA")
    private String fecha;
    
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
    @JoinColumn(name="ID_ANALISTA")
    private Analista analista;  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVICIO")
    private Servicio servicio;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_MODULO")
    private Modulo modulo;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVICIO_MODULO")
    private ServicioModulo servicioModulo;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVIDOR")
    private Servidor servidor;   

    @ManyToOne(optional = false)
    @JoinColumn(name="ID_IMPACTO")
    private Impacto impacto;  
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_ESTADO")
    private Estado estado;
  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_RAIZ")
    private Raiz raiz;
    
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "TICKET_SEGUIMIENTO", 
        joinColumns = { @JoinColumn(name = "ID_TICKET") }, 
        inverseJoinColumns = { @JoinColumn(name = "ID_SEGUIMIENTO") })
    private List<Seguimiento> seguimientos = new ArrayList<Seguimiento>();
    
    
    public Ticket(){
        
    }
    
    public Ticket(String titulo, String fechaInicio, String fechaFin, String descripcion, String causa, String solucion){        
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaActual = Calendar.getInstance().getTime();   
        String hoy = df.format(fechaActual);
        
        this.causa=causa;
        this.descripcion=descripcion;
        this.titulo=titulo;
        this.solucion=solucion;   
        this.fechaFin=fechaFin;
        this.fechaInicio=fechaInicio;   
        this.fecha=hoy;
        
    }
             
   
        public int getId() {
            return idTicket;
        }
 
        public void setId(int id) {
            this.idTicket = id;
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

  
    public Raiz getRaiz() {
        return raiz;
    }

    public void setRaiz(Raiz raiz) {
        this.raiz = raiz;
    }

  
    public List<Seguimiento> getSeguimientos() {
        return seguimientos;
    }

  
    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }
    

   
    public Servidor getServidor() {
        return servidor;
    }

  
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

  
    public ServicioModulo getServicioModulo() {
        return servicioModulo;
    }

   
    public void setServicioModulo(ServicioModulo servicioModulo) {
        this.servicioModulo = servicioModulo;
    }

  

    
    
    
    
            
      
    
    
    
}

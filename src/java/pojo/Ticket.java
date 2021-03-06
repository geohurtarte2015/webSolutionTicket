

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
    public int idTicket;
    
    @Column(name="TITULO")
    public String titulo;
    
    @Column(name="FECHA")
    public String fecha;
    
    @Column(name="FECHA_INICIO")    
    public String fechaInicio;
    
    @Column(name="FECHA_FIN")    
    public String fechaFin;       
    
    @Column(name="DESCRIPCION")    
    public String descripcion;
    
    @Column(name="CAUSA")
    public String causa;
    
    @Column(name="SOLUCION")
    public String solucion;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_ANALISTA")
    public Analista analista;  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVICIO")
    public Servicio servicio;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_MODULO")
    public Modulo modulo;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVICIO_MODULO")
    public ServicioModulo servicioModulo;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_SERVIDOR")
    public Servidor servidor;   

    @ManyToOne(optional = false)
    @JoinColumn(name="ID_IMPACTO")
    public Impacto impacto;  
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_ESTADO")
    public Estado estado;
  
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_RAIZ")
    public Raiz raiz;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_AGENCIA")
    private Agencia agencia;
    
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "TICKET_SEGUIMIENTO", 
        joinColumns = { @JoinColumn(name = "ID_TICKET") }, 
        inverseJoinColumns = { @JoinColumn(name = "ID_SEGUIMIENTO") })
    public List<Seguimiento> seguimientos = new ArrayList<Seguimiento>();
    
    
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
    
    
 
    public Agencia getAgencia() {
        return agencia;
    }


    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

  

    
    
    
    
            
      
    
    
    
}

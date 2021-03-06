package pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "SEGUIMIENTO")
public class Seguimiento implements Serializable {
 
    @Id
    @GeneratedValue
    @Column(name = "ID_SEGUIMIENTO")
     public int id;
 
    @Column(name = "DESCRIPCION")
      String descripcion;   
    
    @Column(name = "FECHA")
     public String fecha;
     
     
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="seguimientos")
    public List<Ticket> tickets = new ArrayList<Ticket>();
     
    public Seguimiento(){
         
    }
     
    public Seguimiento(String descripcion,String fecha){
        this.descripcion = descripcion;
        this.fecha = fecha;
        
    }
 
 
    public List<Ticket> getTickets() {
        return tickets;
    }
 
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    



    public String getDescripcion() {
        return descripcion;
    }

 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
  
}
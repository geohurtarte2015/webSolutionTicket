package pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.Column;
import javax.persistence.Entity;
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
     private long id;
 
    @Column(name = "DESCRIPCION")
      String descripcion;   
    
    @Column(name = "FECHA")
     private String fecha;
     
     
    @ManyToMany(mappedBy="seguimientos")
    private List<Ticket> tickets = new ArrayList<Ticket>();
     
    public Seguimiento(){
         
    }
     
    public Seguimiento(String descripcion,String fecha){
        this.descripcion = descripcion;
        this.fecha = fecha;
        
    }
 
 
    public List<Ticket> getTickets() {
        return tickets;
    }
 
    public void setStudents(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    



    public String getDescripcion() {
        return descripcion;
    }

 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
  
}
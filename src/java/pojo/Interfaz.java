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
@Table(name = "INTERFAZ")
public class Interfaz implements Serializable {
 
    @Id
    @GeneratedValue
    @Column(name = "ID_INTERFAZ")
     public int id;
 
    @Column(name = "DESCRIPCION")
      String descripcion;   
    
    @Column(name = "IP")
     public String ip;
     
     
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy="interfaces")
    public List<Agencia> agencias = new ArrayList<Agencia>();
     
    public Interfaz(){
         
    }
     
    public Interfaz(String descripcion,String ip){
        this.descripcion = descripcion;
        this.ip = ip;
        
    }
 
 
    public List<Agencia> getAgencias() {
        return agencias;
    }
 
    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
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
 
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
  
}
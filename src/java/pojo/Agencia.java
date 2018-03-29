
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="AGENCIA")
public class Agencia implements Serializable {
    
  
    @Id
    @GeneratedValue
    @Column(name = "ID_AGENCIA")
    public int idAgencia;
    
    @Column(name="DESCRIPCION")
    public String descripcion;    
    
       
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "AGENCIA_INTERFAZ", 
        joinColumns = { @JoinColumn(name = "ID_AGENCIA",
            referencedColumnName="ID_AGENCIA",
            nullable=false) }, 
        inverseJoinColumns = { @JoinColumn(name = "ID_INTERFAZ",
            referencedColumnName="ID_INTERFAZ",
            nullable=false) })
    public List<Interfaz> interfaces = new ArrayList<Interfaz>();

    
    public Agencia(){
    
    }
    
    public Agencia(String descripcion){
        
        this.descripcion=descripcion;
    }

    
    public int getIdAgencia() {
        return idAgencia;
    }
  
    
    public void setIdAgencia(int idInterfaces) {
        this.idAgencia = idInterfaces;
    }
  
    
    public String getDescripcion() {
        return descripcion;
    }

    
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
      public List<Interfaz> getInterfaces() {
        return interfaces;
    }

  
    public void setInterfaces(List<Interfaz> interfaces) {
        this.interfaces = interfaces;
    }
    
   


}

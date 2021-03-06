
package pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="MODULO")
public class Modulo implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_MODULO")
    public int idModulo;
    
    @Column(name="DESCRIPCION")
    public String descripcion;
    

   
    public Modulo(){
        
    }
    
     public Modulo(String descripcion){
         this.descripcion = descripcion;
    }
    

    
    public int getIdModulo() {
        return idModulo;
    }


    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

  
    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
}

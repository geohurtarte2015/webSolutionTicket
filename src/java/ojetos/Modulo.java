
package ojetos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="MODULO")
public class Modulo implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_MODULO")
    private int idModulo;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
   
    public Modulo(){
        
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

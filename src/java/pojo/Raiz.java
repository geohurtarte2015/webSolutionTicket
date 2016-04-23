
package pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RAIZ")
public class Raiz implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_RAIZ")
    private int idRaiz;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    public Raiz(){
    
    }
    
     public Raiz(String descripcion){         
         this.descripcion = descripcion;
    }
  
  
    public int getIdRaiz() {
        return idRaiz;
    }

   
    public void setIdRaiz(int idRaiz) {
        this.idRaiz = idRaiz;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

   
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
        
    
    
}

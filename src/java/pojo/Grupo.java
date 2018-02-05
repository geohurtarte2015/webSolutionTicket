
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
@Table(name="GRUPO")
public class Grupo implements Serializable {
    
    
    @Id
    @GeneratedValue
    @Column(name = "ID_GRUPO")
    public int idGrupo;
    
    @Column(name="DESCRIPCION")
    public String descripcion;
   
   
    
    public Grupo() {
 
    }
    
    public Grupo(String descripcion) {
        this.descripcion=descripcion; 
    }


   
    public int getIdAnalista() {
        return idGrupo;
    }

  
    public void setIdAnalista(int idGrupo) {
        this.idGrupo = idGrupo;
    }

 
    
    
    
    
    
    
    
}


package ojetos;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ESTADO")
public class Estado implements Serializable {
    
    
    @Id
    @GeneratedValue
    @Column(name = "ID_ESTADO")
    private int idEstado;
    
    @Column(name="DESCRIPCION")
    private String descripcion;

    public Estado(){
    
    
    }
    
    
    public int getIdEstado() {
        return idEstado;
    }

    
 
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }


    
    
    public String getDescripcion() {
        return descripcion;
    }

 
    
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

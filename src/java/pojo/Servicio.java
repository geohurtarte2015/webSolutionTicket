
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
@Table(name = "SERVICIO")
public class Servicio implements Serializable {
    
    
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICIO")  
    public int idServicio;
    
    @Column(name="DESCRIPCION")
    public String descripcion;    


    public Servicio(){
        
    }
    
    public Servicio(String descripcion){
        this.descripcion = descripcion;
    }

    public int getIdServicioModulo() {
        return idServicio;
    }


    public void setIdServicioModulo(int idServicioModulo) {
        this.idServicio = idServicioModulo;
    }


    public String getDescripcion() {
        return descripcion;
    }

  
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   

    
}

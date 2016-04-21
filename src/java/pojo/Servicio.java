
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
    private int idServicio;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
     
    @ManyToOne(optional = false)
    @JoinColumn(name="ID_MODULO")
    private Modulo modulo;



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

   
    public Modulo getModulo() {
        return modulo;
    }

  
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
}

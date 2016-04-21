
package ojetos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SEGUIMIENTO")
public class Seguimiento implements Serializable {
    
@Id
@GeneratedValue
@Column(name="ID_SEGUIMIENTO")
private int idSeguimiento;

@Column(name="DESCRIPCION")
private String descripcion;

@Column(name="FECHA")
private String fecha;

@ManyToMany(mappedBy="SEGUIMIENTO")
private  List<Ticket> tickets = new ArrayList<Ticket>();

public Seguimiento(){
    
}

 
    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    
    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}

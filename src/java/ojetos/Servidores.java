
package ojetos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVIDORES")
public class Servidores implements Serializable {
    
  
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVIDOR")
    private int idServidores;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name="IP")    
    private String ip;

    public Servidores(){
        
    }
    
    public int getIdServidores() {
        return idServidores;
    }

  
    
    public void setIdServidores(int idServidores) {
        this.idServidores = idServidores;
    }

  
    
    public String getDescripcion() {
        return descripcion;
    }

    
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
    public String getIp() {
        return ip;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }
    
}

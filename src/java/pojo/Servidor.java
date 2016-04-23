
package pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVIDOR")
public class Servidor implements Serializable {
    
  
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVIDOR")
    private int idServidor;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name="IP")    
    private String ip;
    
    public Servidor(){
    
    }

    public Servidor(String descripcion, String ip){        
        this.descripcion = descripcion;
        this.ip = ip;
    }
    
    public int getIdServidor() {
        return idServidor;
    }

  
    
    public void setIdServidor(int idServidores) {
        this.idServidor = idServidores;
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

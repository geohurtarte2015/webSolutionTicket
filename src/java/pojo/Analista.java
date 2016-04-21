
package pojo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANALISTA")
public class Analista implements Serializable {
    
    
    @Id
    @GeneratedValue
    @Column(name = "ID_ANALISTA")
    private int idAnalista;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="APELLIDO")
    private String apellido;
    
    @Column(name="USUARIO")
    private String usuario;
    
    @Column(name="PASSWORD")
    private String password;
    
    public Analista() {
 
    }
    
    public Analista(String nombre, String apellido, String usuario, String password) {
        
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
        this.password=password;
 
    }
    

   
    public int getIdAnalista() {
        return idAnalista;
    }

  
    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }

 
    public String getNombre() {
        return nombre;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

  
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    
    public String getUsuario() {
        return usuario;
    }


    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    
    public String getPassword() {
        return password;
    }

  
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
}

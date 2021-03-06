/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="SERVICIO_MODULO")
public class ServicioModulo implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICIO_MODULO") 
    public int idServicioModulo;
    
    @Column(name="DESCRIPCION")
    public String descripcion;
    
    
    public ServicioModulo() {
        
    }
    
    public ServicioModulo(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public int getIdServicioModulo() {
        return idServicioModulo;
    }

  
    public void setIdServicioModulo(int idServicioModulo) {
        this.idServicioModulo = idServicioModulo;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

  
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

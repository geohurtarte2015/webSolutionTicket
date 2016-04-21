/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="SERVICIO_MODULO")
public class ServicioModulo {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICIO_MODULO") 
    private int idServicioModulo;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    
    public ServicioModulo() {
        
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

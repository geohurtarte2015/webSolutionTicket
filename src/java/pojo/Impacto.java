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
@Table(name="IMPACTO")
public class Impacto implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_IMPACTO")
    public int idImpacto;
    
    @Column(name="DESCRIPCION")
    public String descripcion;

    public Impacto(){
    
    }
    
    public Impacto(String descripcion){
        this.descripcion = descripcion;
    }
    
    
    public int getIdImpacto() {
        return idImpacto;
    }

 
    
    public void setIdImpacto(int idImpacto) {
        this.idImpacto = idImpacto;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

  
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
            
    
}

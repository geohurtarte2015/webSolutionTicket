/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoAnalista;
import dao.DaoEstado;
import dao.DaoModulo;
import dao.DaoServicioModulo;
import pojo.Analista;
import pojo.Estado;
import pojo.ServicioModulo;
import pojo.Modulo;
/**
 *
 * @author Giovanni
 */
public class Test {
    
    
    public static void main(String[] args){
        DaoAnalista daoAnalista = new DaoAnalista();
        DaoEstado daoEstado = new DaoEstado();
        DaoServicioModulo daoServicioModulo = new DaoServicioModulo();
        DaoModulo daoModulo = new DaoModulo();
        
        
        
        
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");
        daoAnalista.SaveObject((Analista) analista);
        
        Estado estado = new Estado("Activo");
        Estado estado2 = new Estado("Cerrado");
        daoEstado.SaveObject((Estado)estado);
        daoEstado.SaveObject((Estado)estado2);        
        
        ServicioModulo servicioModulo = new ServicioModulo("Depuracion TC");
        ServicioModulo servicioModulo2 = new ServicioModulo("Logueo");
        ServicioModulo servicioModulo3 = new ServicioModulo("Conexion Seguridad");
        
        daoServicioModulo.SaveObject((ServicioModulo)servicioModulo);        
        daoServicioModulo.SaveObject((ServicioModulo)servicioModulo2);
        daoServicioModulo.SaveObject((ServicioModulo)servicioModulo3);
        
        
        Modulo modulo = new Modulo("Portal Financiero");
        Modulo modulo2 = new Modulo("Banca para Ti");
        
        modulo.setServicioModulo(servicioModulo);
        modulo2.setServicioModulo(servicioModulo2);
        modulo2.setServicioModulo(servicioModulo3);
        
        daoModulo.SaveObjectManyToOne((Modulo)modulo);
        daoModulo.SaveObjectManyToOne((Modulo)modulo2);
        
        
        
        
   
    
        
        
        
    }
    
}

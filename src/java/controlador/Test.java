
package controlador;

import dao.DaoModulo;
import dao.DaoServicio;
import dao.DaoAnalista;
import dao.DaoImpacto;
import dao.DaoEstado;
import dao.DaoRaiz;
import dao.DaoSeguimiento;
import dao.DaoServicioModulo;
import dao.DaoTicket;
import dao.DaoServidor;
import java.util.Iterator; 

import pojo.Analista;
import pojo.Estado;
import pojo.Impacto;
import pojo.ServicioModulo;
import pojo.Modulo;
import pojo.Raiz;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.Servidor;
import pojo.Ticket;



public class Test {
    
    
    public static void main(String[] args){
        
        DaoAnalista daoAnalista = new DaoAnalista();
        DaoEstado daoEstado = new DaoEstado();
        DaoImpacto daoImpacto = new DaoImpacto();
        DaoModulo daoModulo = new DaoModulo();
        DaoRaiz daoRaiz = new DaoRaiz();
        DaoSeguimiento daoSeguimiento = new DaoSeguimiento();
        DaoServicio daoServicio = new DaoServicio();
        DaoServicioModulo daoServicioModulo = new DaoServicioModulo();
        DaoServidor daoServidor = new DaoServidor();        
        DaoTicket daoTicket = new DaoTicket();
    
    
    /*
        //Crea objeto Analista
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");     
        daoAnalista.save(analista);
        
        
        //Crea objeto Estado
        Estado estado = new Estado("Activo");
        daoEstado.save(estado);
  
       
        //Crea objeto Impacto
        Impacto impacto = new Impacto("Alto");
        daoImpacto.save(impacto);
       
        //Crea objeto Servidor
        Servidor servidor = new Servidor("MALINAS","192.168.1.1");
        daoServidor.save(servidor);
              
        //Crea objeto Raiz
        Raiz raiz = new Raiz("Portal");
        daoRaiz.save(raiz);   
                
        //Crea objeto Servicio Modulo
        ServicioModulo servicioModulo = new ServicioModulo("Bancasat");
        daoServicioModulo.save(servicioModulo);
        
        //Crea objeto Modulo
        Modulo modulo = new Modulo("Banca Empresarial");    
        daoModulo.save(modulo);
        
        //Crea objeto servicio
        Servicio servicio = new Servicio("Banca Empresarial"); 
        daoServicio.save(servicio);
    
      
        
        //Seguimiento
        Seguimiento seguimiento = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");    
        Seguimiento seguimiento2 = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");   
           
        
        
        //Crea objeto Ticket
        Ticket ticket = new Ticket("Titulo","fecha","fecha Inicio","Fecha Final","Causa","Descripcion"); 
        
        
        //Guarda en base de datos y hace persistencia datos con todos los objetos incluidos
        daoTicket.save(1, 1, 1, 1, 1, seguimiento, 1, 1, 1, ticket);
        
        //agrega seguimientos despues de haber guardado un ticket
        daoTicket.addSeguimiento(1, seguimiento2);        
        */
        
    
    
       System.out.println("*****HAY " + daoModulo.listAll().size() + " OBJECTOS(S)*******");
       
       Modulo modulo = daoModulo.getOne(1);
       Servicio servicio = daoServicio.getOne(1);
       
       System.out.println(modulo.getDescripcion());
       System.out.println(servicio.getDescripcion());
    
       for (Iterator iterator =  daoAnalista.listAll().iterator(); 
            iterator.hasNext();){
            Analista analista = (Analista) iterator.next(); 
            System.out.print("Nombre: " + analista.getNombre()+"\n"); 
            System.out.print("Apellido: " + analista.getApellido()+"\n");      
            System.out.print("Password " + analista.getPassword()+"\n");  
            System.out.print("Usuario " + analista.getUsuario()+"\n");  
         }

    }
    
}

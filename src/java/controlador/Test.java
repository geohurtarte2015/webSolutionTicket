
package controlador;

import modelo.HibernateUtil;
import org.hibernate.Session;
import dao.DaoTicket;
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
        
        DaoTicket daoTicket = new DaoTicket();
    
       
       //Crea objeto Analista
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");
        
        
        //Crea objeto Estado
        Estado estado = new Estado("Activo");
  
       
        //Crea objeto Impacto
        Impacto impacto = new Impacto("Alto");
       
       //Crea objeto Servidor
        Servidor servidor = new Servidor("MALINAS","192.168.1.1");
              
        //Crea objeto Raiz
        Raiz raiz = new Raiz("Portal");
       
        //Seguimiento
        Seguimiento seguimiento = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");    
        Seguimiento seguimiento2 = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");   
           
        
        //Crea objetos ServicioModulo, Modulo y Servicio
        ServicioModulo servicioModulo = new ServicioModulo("Bancasat");
        Modulo modulo = new Modulo("Banca Empresarial");
        modulo.setServicioModulo(servicioModulo);      
        Servicio servicio = new Servicio("Banca Empresarial");
        servicio.setModulo(modulo);        
        
        //Crea objeto Ticket
        Ticket ticket = new Ticket("Titulo","fecha","fecha Inicio","Fecha Final","Causa","Descripcion"); 
        
        
        
        //Guarda en base de datos y hace persistencia datos con todos los objetos incluidos
        daoTicket.save(servidor, estado, impacto, raiz, analista, seguimiento, servicioModulo, modulo, servicio, ticket);
        daoTicket.addSeguimiento(1, seguimiento2);
    
        
    }
    
}

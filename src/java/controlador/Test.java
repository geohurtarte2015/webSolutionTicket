/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoAnalista;
import dao.DaoEstado;
import dao.DaoImpacto;
import dao.DaoServidor;
import dao.DaoModulo;
import dao.DaoRaiz;
import dao.DaoSeguimiento;
import dao.DaoServicio;
import dao.DaoServicioModulo;
import dao.DaoTicket;
import modelo.HibernateUtil;
import org.hibernate.Session;
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
/**
 *
 * @author Giovanni
 */
public class Test {
    
    
    public static void main(String[] args){
       DaoAnalista daoAnalista = new DaoAnalista();
       DaoEstado daoEstado = new DaoEstado();
       DaoServidor daoServidor = new DaoServidor();
       DaoServicioModulo daoServicioModulo = new DaoServicioModulo();
       DaoModulo daoModulo = new DaoModulo();
       DaoRaiz daoRaiz = new DaoRaiz();
       DaoImpacto daoImpacto = new DaoImpacto();
       DaoServicio daoServicio = new DaoServicio();
       DaoTicket daoTicket = new DaoTicket();
       DaoSeguimiento daoSeguimiento = new DaoSeguimiento();
        
       
       
       
       
       
       //Guarda Analista
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");
        
        
        //Guarda Estado
        Estado estado = new Estado("Activo");
        Estado estado2 = new Estado("Cerrado");
       
        //Guarda Impacto
       Impacto impacto = new Impacto("Alto");
       
       //Guarda Servidor
       Servidor servidor = new Servidor("MALINAS","192.168.1.1");
       
       
        //Guarda Raiz
       Raiz raiz = new Raiz("Portal");
       
       //Seguimiento
       Seguimiento seguimiento = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");                
       Seguimiento seguimiento2 = new Seguimiento("Seguimiento3 de caso Ticket","25/04/2016"); 
             
        
        //Guarda ServicioModulo, Modulo y Servicio
       ServicioModulo servicioModulo = new ServicioModulo("Bancasat");
       
        
       Modulo modulo = new Modulo("Banca Empresarial");
       modulo.setServicioModulo(servicioModulo);
      
       
       Servicio servicio = new Servicio("Banca Empresarial");
       servicio.setModulo(modulo);
        
        
        //Guarda Ticket
        Ticket ticket = new Ticket("Causa","Descripcion del Ticket","Solucion N Casos","Test Ticket");
          
        
      
        
        ticket.setAnalista(analista);
        ticket.setEstado(estado);
        ticket.setImpacto(impacto);
        ticket.setRaiz(raiz);
        ticket.setServidor(servidor);
        ticket.getSeguimientos().add(seguimiento);
        ticket.getSeguimientos().add(seguimiento2);      
        ticket.setServicio(servicio);
       
        
        
        
        
        daoImpacto.SaveObjectManyToOne(servidor);
        daoEstado.SaveObjectManyToOne((Estado)estado); 
        daoImpacto.SaveObjectManyToOne(impacto);
        daoRaiz.SaveObjectManyToOne(raiz);        
        daoAnalista.SaveObjectManyToOne((Analista) analista);
        daoSeguimiento.SaveObject((Seguimiento)seguimiento);
        daoSeguimiento.SaveObject((Seguimiento)seguimiento2);
        daoServicioModulo.SaveObjectManyToOne(servicioModulo);
        daoModulo.SaveObjectManyToOne(modulo);
        daoServicio.SaveObjectManyToOne(servicio);
        daoTicket.SaveObjectManyToOne(ticket);
        
//        
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction(); 
//        session.persist(servidor);
//        session.persist(estado);              
//        session.persist(impacto);
//        session.persist(raiz);
//        session.persist(analista);
//        session.persist(seguimiento);
//        session.persist(seguimiento2);
//        session.persist(servicioModulo);
//        session.persist(modulo);
//        session.persist(servicio);       
//        session.persist(ticket);
//        
//        session.getTransaction().commit();
//        session.close();
//        
    }
    
}

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
        
       
       //Guarda ServicioModulo, Modulo y Servicio
       ServicioModulo servicioModulo = new ServicioModulo("Bancasat");
       daoServicioModulo.SaveObject(servicioModulo);
        
       Modulo modulo = new Modulo("Banca Empresarial");
       modulo.setServicioModulo(servicioModulo);
       daoModulo.SaveObjectManyToOne(modulo);
       
       Servicio servicio = new Servicio("Banca Empresarial");
       servicio.setModulo(modulo);
       daoServicio.SaveObjectManyToOne(servicio);
       
       
       //Guarda Servidor
       Servidor servidor = new Servidor("MALINAS","192.168.1.1");
       daoServidor.SaveObject(servidor);
      
       
       //Guarda Impacto
       Impacto impacto = new Impacto("Alto");
       daoImpacto.SaveObject(impacto);
      
       
        //Guarda Raiz
       Raiz raiz = new Raiz("Portal");
       daoRaiz.SaveObject(raiz);
       
       //Guarda Analista
        Analista analista = new Analista("Giovanni","Hurtarte","geo","hurtarte2016");
        daoAnalista.SaveObject((Analista) analista);
        
        
        //Guarda Estado
        Estado estado = new Estado("Activo");
        Estado estado2 = new Estado("Cerrado");
        daoEstado.SaveObject((Estado)estado);
        daoEstado.SaveObject((Estado)estado2);
        
        
        //Guarda Ticket
        Ticket ticket = new Ticket("Causa","Descripcion del Ticket","Solucion N Casos","Test Ticket");
        Seguimiento seguimiento = new Seguimiento("Seguimiento de caso Ticket","25/04/2016");                
        Seguimiento seguimiento2 = new Seguimiento("Seguimiento3 de caso Ticket","25/04/2016");   
        
        ticket.getSeguimientos().add(seguimiento);

        seguimiento.getTickets().add(ticket);
        
        ticket.setAnalista(analista);
        ticket.setEstado(estado);
        ticket.setImpacto(impacto);
        ticket.setRaiz(raiz);
        ticket.setServicio(servicio);
        ticket.setServidor(servidor);        
      
        daoTicket.SaveObjectManyToOne(ticket);
        
    }
    
}

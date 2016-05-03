
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



public class Test2 {
    
    
    public static void main(String[] args){
              
       DaoTicket daoTicket = new DaoTicket();
       //daoTicket.update(1, 1, 1, 1, 1, 9, 1, 1, 1, "Causa Ticket", "descripcion", "03/05/2016", "03/05/2016", "Solucion Ticket", "Titulo Ticket");
       daoTicket.delete(1);
    }
    
}

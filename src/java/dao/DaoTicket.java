package dao;

import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Analista;
import pojo.Estado;
import pojo.Impacto;
import pojo.Modulo;
import pojo.Raiz;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.ServicioModulo;
import pojo.Servidor;
import pojo.Ticket;



public class DaoTicket {
    
    private Session sesion;
    private Transaction tx;
    
   public void save(Servidor servidor, Estado estado, Impacto impacto, Raiz raiz,Analista analista,
   Seguimiento seguimiento,ServicioModulo servicioModulo, Modulo modulo,Servicio servicio, Ticket ticket ) throws HibernateException {
  
    try{
        //Arma el objeto
        ticket.setAnalista(analista);
        ticket.setEstado(estado);
        ticket.setImpacto(impacto);
        ticket.setRaiz(raiz);
        ticket.setServidor(servidor);
        ticket.getSeguimientos().add(seguimiento);          
        ticket.setServicio(servicio);                
    
        //inicia persitencia y  guarda (commit)
        initOperation();
        sesion.persist(servidor);
        sesion.persist(estado);              
        sesion.persist(impacto);
        sesion.persist(raiz);
        sesion.persist(analista);
        sesion.persist(seguimiento);     
        sesion.persist(servicioModulo);
        sesion.persist(modulo);
        sesion.persist(servicio);       
        sesion.persist(ticket);
        tx.commit();
        
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        throw he; 
    
    
    } finally
    {
                
        sesion.close();
    
    }
    
    

}

   public void addSeguimiento(int idTicket, Seguimiento seguimiento )
   {
  
      try{
            initOperation();
            Ticket ticket = 
            (Ticket)sesion.get(Ticket.class, idTicket); 

            ticket.getSeguimientos().add(seguimiento);  
            sesion.persist(ticket);
            tx.commit();
        }catch(HibernateException he)
       {        
            trueExcepcion(he); 
            throw he; 
    
       } finally
       {
                
            sesion.close();
    
       }
    }
   
    private void initOperation() throws HibernateException 

    {
    
    sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    
}

    private void trueExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    }
    
    
}
    


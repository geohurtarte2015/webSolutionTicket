package dao;

import java.util.List;
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
   
   public void save(int idServidor, int idEstado, int idImpacto, int idRaiz, int idAnalista,
   Seguimiento seguimiento,int idServicioModulo, int idModulo,int idServicio, Ticket ticket ) throws HibernateException {
  
    try{
        //inicia persitencia y  guarda (commit)
        initOperation();
        Servidor servidor = 
        (Servidor)sesion.get(Servidor.class, idServidor); 
        
        Estado estado = 
        (Estado)sesion.get(Estado.class, idEstado); 
        
        Impacto impacto = 
        (Impacto)sesion.get(Impacto.class, idImpacto); 
        
        Raiz raiz = 
        (Raiz)sesion.get(Raiz.class, idRaiz);
        
        Analista analista = 
        (Analista)sesion.get(Analista.class, idAnalista);

        ServicioModulo servicioModulo = 
        (ServicioModulo)sesion.get(ServicioModulo.class, idServicioModulo); 
        
        Modulo modulo = 
        (Modulo)sesion.get(Modulo.class, idModulo); 
        
        Servicio servicio = 
        (Servicio)sesion.get(Servicio.class, idServicio); 
        
        

        
        //Arma el objeto
        ticket.setAnalista(analista);
        ticket.setEstado(estado);
        ticket.setImpacto(impacto);
        ticket.setRaiz(raiz);
        ticket.setServidor(servidor);
        ticket.setServicio(servicio); 
        ticket.setModulo(modulo);
        ticket.setServicioModulo(servicioModulo);
        ticket.getSeguimientos().add(seguimiento);          
      
   
        sesion.persist(servidor);
        sesion.persist(estado);              
        sesion.persist(impacto);
        sesion.persist(raiz);
        sesion.persist(analista);
        sesion.persist(servicioModulo);
        sesion.persist(modulo);
        sesion.persist(servicio);
        sesion.persist(seguimiento);   
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
    
   public List<Ticket> listAll(){
       
       List<Ticket> tickets = null;
       
       try{
           initOperation();
           tickets= sesion.createQuery("from Ticket").list(); 
      
       } finally
       {
        sesion.close();
        
       }
       
       return tickets;
   }  
    
   public Ticket getByIdObject(int idTicket){
       Ticket ticket = null;
       try{
           
           initOperation();
           ticket = (Ticket) sesion.get(Ticket.class, idTicket);    
         
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return ticket;
   }
   
   public Ticket update(int idTicket, int idServidor, int idEstado, int idImpacto, int idRaiz, int idAnalista,
   int idServicioModulo, int idModulo,int idServicio, String causa, String descripcion, String fechaFin, 
   String fechaInicio, String solucion,String titulo){
     
       Ticket ticket = null;
       DaoTicket daoTicket = new DaoTicket();
       
       try{        
           ticket = daoTicket.getByIdObject(idTicket); 
           DaoAnalista daoAnalista = new DaoAnalista();
           DaoEstado daoEstado = new DaoEstado();
           DaoRaiz daoRaiz = new DaoRaiz();     
           DaoServicio daoServicio = new DaoServicio();
           DaoServicioModulo daoServicioModulo = new DaoServicioModulo();
           DaoServidor daoServidor = new DaoServidor();
           DaoImpacto daoImpacto = new DaoImpacto();
           DaoModulo daoModulo = new DaoModulo();
            
           initOperation();   
           ticket.setAnalista(daoAnalista.getByIdObject(idAnalista));
           ticket.setEstado(daoEstado.getByIdObject(idEstado));
           ticket.setImpacto(daoImpacto.getByIdObject(idImpacto));
           ticket.setModulo(daoModulo.getByIdObject(idModulo));
           ticket.setRaiz(daoRaiz.getByIdObject(idRaiz));
           ticket.setEstado(daoEstado.getByIdObject(idEstado));
           ticket.setServicio(daoServicio.getByIdObject(idServicio));
           ticket.setServicioModulo(daoServicioModulo.getByIdObject(idServicioModulo));
           ticket.setServidor(daoServidor.getByIdObject(idServidor));
           
           ticket.setDescripcion(descripcion);
           ticket.setCausa(causa);
           ticket.setFechaFin(fechaFin);
           ticket.setFechaInicio(fechaInicio);
           ticket.setSolucion(solucion);
           ticket.setTitulo(titulo);

           //ticket.getSeguimientos().set(idRaiz);

           sesion.update(ticket);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return ticket;
   
   
   }
   
   public Ticket delete(int idTicket){
     Ticket ticket = null;
       try{           
           initOperation();
           ticket = (Ticket) sesion.get(Ticket.class, idTicket);                    
           sesion.delete(ticket);
           tx.commit();
           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return ticket;
   
   
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
    


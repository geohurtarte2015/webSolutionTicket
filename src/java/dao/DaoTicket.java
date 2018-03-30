package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Agencia;
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
   
   public String save(int idServidor, int idEstado, int idImpacto, int idRaiz, int idAnalista,
   int idServicioModulo, int idModulo,int idServicio, int idAgencia, Ticket ticket ) throws HibernateException {
   String resp=null;
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
        
        Agencia agencia =
         (Agencia)sesion.get(Agencia.class, idAgencia);
        
        //Arma el objeto
        ticket.setAnalista(analista);
        ticket.setEstado(estado);
        ticket.setImpacto(impacto);
        ticket.setRaiz(raiz);
        ticket.setServidor(servidor);
        ticket.setServicio(servicio); 
        ticket.setModulo(modulo);
        ticket.setServicioModulo(servicioModulo);
        ticket.setAgencia(agencia);
       
      
   
        sesion.persist(servidor);
        sesion.persist(estado);              
        sesion.persist(impacto);
        sesion.persist(raiz);
        sesion.persist(analista);
        sesion.persist(servicioModulo);
        sesion.persist(modulo);
        sesion.persist(servicio);  
        sesion.persist(agencia); 
        sesion.persist(ticket);  
         
        tx.commit();
        resp="ok";
       
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        resp=he.toString(); 
        throw he; 
        
    
    } finally
    {
  
        sesion.close();   
       
 
    
    }
    
    return resp;

}
    
   public List<Ticket> listAll(){
       
       List<Ticket> tickets = null;
       
       try{
           initOperation();
           tickets= sesion.createQuery("from Ticket").list(); 
      
       } finally
       {
        tx.commit();
        sesion.clear();
        sesion.close();
        
       }
       
       return tickets;
   }  
    
   public Ticket getByIdObject(int idTicket){
       Ticket ticket = null;
       try{
           
           initOperation();
           ticket = (Ticket) sesion.get(Ticket.class, idTicket); 
           if(ticket==null){
               
             ticket = new Ticket("","","","","","");
           }
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
             tx.commit();
             sesion.clear();
             sesion.close();
       }
       
       
       return ticket;
   }
   
   public String update(int idTicket, int idServidor, int idEstado, int idImpacto, int idRaiz, int idAnalista,
   int idServicioModulo, int idModulo,int idServicio, String causa, String descripcion, String fechaFin, 
   String fechaInicio, String solucion,String titulo){
     
       Ticket ticket = null;
       String resp="";

       DaoTicket daoTicket = new DaoTicket();
       
       try{        
           ticket = daoTicket.getByIdObject(idTicket); 
           DaoGeneric daoGeneric = new DaoGeneric();
            
           initOperation();   
           ticket.setAnalista((Analista) daoGeneric.getByIdObject(idAnalista, Analista.class));
           ticket.setEstado((Estado) daoGeneric.getByIdObject(idEstado, Estado.class));
           ticket.setImpacto((Impacto) daoGeneric.getByIdObject(idImpacto, Impacto.class));
           ticket.setModulo((Modulo) daoGeneric.getByIdObject(idModulo, Modulo.class));
           ticket.setRaiz((Raiz) daoGeneric.getByIdObject(idRaiz, Raiz.class));      
           ticket.setServicio((Servicio) daoGeneric.getByIdObject(idServicio, Servicio.class));
           ticket.setServicioModulo((ServicioModulo) daoGeneric.getByIdObject(idServicioModulo, ServicioModulo.class));
           ticket.setServidor((Servidor) daoGeneric.getByIdObject(idServidor, Servidor.class));
           
           ticket.setDescripcion(descripcion);
           ticket.setCausa(causa);
           ticket.setFechaFin(fechaFin);
           ticket.setFechaInicio(fechaInicio);
           ticket.setSolucion(solucion);
           ticket.setTitulo(titulo);

           //ticket.getSeguimientos().set(idRaiz);

           sesion.update(ticket);
           resp="ok";
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
             tx.commit();
             sesion.clear();
             sesion.close();
       }
       
       
       return resp;
   
   
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
           
             
             sesion.clear();
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
                
            sesion.clear();
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
    


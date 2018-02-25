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
import pojo.Interfaz;
import pojo.Modulo;
import pojo.Raiz;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.ServicioModulo;
import pojo.Servidor;
import pojo.Ticket;



public class DaoInterfaz {
    
   private Session sesion;
   private Transaction tx;
   
  
   public List<Agencia> listAll(){
       
       List<Agencia> agencias = null;
       
       try{
           initOperation();
           agencias= sesion.createQuery("from Agencia").list(); 
      
       } finally
       {
        tx.commit();
        sesion.clear();
        sesion.close();
        
       }
       
       return agencias;
   }  
    


   
   public void addInterfaz(int idAgencia, Interfaz interfaz )
   {
  
      try{
            initOperation();
            Agencia agencia = 
            (Agencia)sesion.get(Agencia.class, idAgencia); 

            agencia.getInterfaces().add(interfaz);  
            sesion.persist(agencia);
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
   
   public Agencia getByIdObject(int idAgencia){
       Agencia agencia = null;
       try{
           
           initOperation();
           agencia = (Agencia) sesion.get(Agencia.class, idAgencia); 
           if(agencia==null){
               
             agencia = new Agencia("","");
           }
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
             tx.commit();
             sesion.clear();
             sesion.close();
       }
       
       
       return agencia;
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
    


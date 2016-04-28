
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.ServicioModulo;
import pojo.Servidor;


public class DaoServidor {
    
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Servidor servidor ) throws HibernateException {
  
    try{      
        initOperation();
        sesion.persist(servidor);        
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
    
    public List<Servidor> listAll(){
       
       List<Servidor> servidores = null;
       
       try{
           initOperation();
           servidores= sesion.createQuery("from Servidor").list();           
       } finally
       {
        sesion.close();
       }
       
       return servidores;
   }   
    
    public Servidor getOne(int idServidor){
       Servidor servidor = null;
       try{
           
           initOperation();
           servidor = (Servidor) sesion.get(Servidor.class, idServidor);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servidor;
   }
   
    public Servidor update(int idServidor, String ip,String descripcion){
     Servidor servidor = null;
       try{           
           initOperation();
           servidor = (Servidor) sesion.get(Servidor.class, idServidor);  
           servidor.setDescripcion(descripcion);
           servidor.setIp(ip);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servidor;
   
   
   }
   
    public Servidor delete(int idServidor){
     Servidor servidor = null;
       try{           
           initOperation();
           servidor = (Servidor) sesion.get(Servidor.class, idServidor);                    
           sesion.delete(servidor);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servidor;
   
   
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

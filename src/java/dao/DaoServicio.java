
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Modulo;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.ServicioModulo;

public class DaoServicio  {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Servicio servicio ) throws HibernateException {
  
    try{      
        initOperation();
        sesion.persist(servicio);        
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
    
    public List<Servicio> listAll(){
       
       List<Servicio> servicios = null;
       
       try{
           initOperation();
           servicios= sesion.createQuery("from Servicio").list();           
       } finally
       {
        sesion.close();
       }
       
       return servicios;
   }   
    
    public Servicio getOne(int idServicio){
       Servicio servicio = null;
       try{
           
           initOperation();
           servicio = (Servicio) sesion.get(Servicio.class, idServicio);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicio;
   }
   
    public Servicio update(int idServicio, String descripcion){
     Servicio servicio = null;
       try{           
           initOperation();
           servicio = (Servicio) sesion.get(Servicio.class, idServicio);  
           servicio.setDescripcion(descripcion);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicio;
   
   
   }
   
    public Servicio delete(int idServicio){
     Servicio servicio = null;
       try{           
           initOperation();
           servicio = (Servicio) sesion.get(Servicio.class, idServicio);                    
           sesion.delete(servicio);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicio;
   
   
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


package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Analista;
import pojo.Estado;

public class DaoEstado {
    
    private Session sesion;
    private Transaction tx;
    
   public void save(Estado estado ) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(estado);        
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
   
   public List<Estado> listAll(){
       
       List<Estado> estados = null;
       
       try{
           initOperation();
           estados= sesion.createQuery("from Estado").list();           
       } finally
       {
        sesion.close();
       }
       
       return estados;
   }   
    
   public Estado getByIdObject(int idEstado){
       Estado estado = null;
       try{
           
           initOperation();
           estado = (Estado) sesion.get(Estado.class, idEstado);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return estado;
   }
   
   public Estado update(int idEstado, String descripcion){
     Estado estado = null;
       try{           
           initOperation();
           estado = (Estado) sesion.get(Estado.class, idEstado);  
           estado.setDescripcion(descripcion);
           sesion.update(estado);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return estado;
   
   
   }
   
    public Estado delete(int idEstado){
     Estado estado = null;
       try{           
           initOperation();
           estado = (Estado) sesion.get(Estado.class, idEstado);                    
           sesion.delete(estado);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return estado;
   
   
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

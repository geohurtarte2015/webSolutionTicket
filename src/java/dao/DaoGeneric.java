
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Analista;
import pojo.Estado;

public class DaoGeneric {
    
    private Session sesion;
    private Transaction tx;
    
   public void save(Object object ) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(object);        
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
   
   public List<?> listAll(String cls){
       
       List<?> object = null;
       
       try{
           initOperation();      
           object= sesion.createQuery("from "+cls).list();           
       } finally
       {
        sesion.close();
       }
       
       return object;
   }   
    
   public Object getByIdObject(int id,Class<?> object){
       Object objectGeneric = null;
       try{
           initOperation();
           objectGeneric = (Object) sesion.get(object, id);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       return object;
   }
   
   public Object update(Object object){     
       try{           
           initOperation();
           sesion.update(object);
           tx.commit();
       }catch(HibernateException he){
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return object;
   
   
   }
   
    public String delete(int id,Class<?> object){
     Object objectGeneric = object;
     String resp=null;
       try{           
           initOperation();
           objectGeneric = (Object) sesion.get(object, id); 
           sesion.delete(objectGeneric);
           tx.commit();
           resp="ok";
       }catch(HibernateException he){        
        trueExcepcion(he); 
        resp=he.toString(); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }       
       return resp;
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

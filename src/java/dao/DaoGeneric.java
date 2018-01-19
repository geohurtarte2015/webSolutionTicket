package dao;




import java.util.List;
import modelo.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DaoGeneric {
    
    private Session sesion;
    private Transaction tx;
    
   public void save(Object object) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(object);        
        
        
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        throw he; 
    
    
    } finally
    {
        tx.commit();
        sesion.clear();
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
        tx.commit();
        sesion.clear();
        sesion.close();
       }
       
       return object;
   }    
    
   public Object getByIdObject(int id,Class<?> object){
       Object objectGeneric = object;
       try{
           initOperation();
           objectGeneric = (Object) sesion.get(object, id);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           tx.commit();
           sesion.close();
       }
       return objectGeneric;
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
     String resp=null;
       try{           
           initOperation();
           Object ob = sesion.load(object, id);
           sesion.delete(ob);
       }catch(HibernateException he){        
        trueExcepcion(he); 
        resp=he.toString(); 
        throw he; 
       
       } finally {
           tx.commit();
           resp="ok";
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

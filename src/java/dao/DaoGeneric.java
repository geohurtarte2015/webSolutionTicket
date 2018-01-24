package dao;




import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


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
           int size = object.size();
           for(int x=0;x<size;x++){
               
               Object baseObject = object.get(x);
               Class classObject = baseObject.getClass();
               Field[] arrayClass = classObject.getFields();
               System.out.println(classObject.getField(arrayClass[0].getName()).get(baseObject));
               
           }
           System.out.println("\n");
           
       } catch (NoSuchFieldException ex) {
            Logger.getLogger(DaoGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DaoGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DaoGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DaoGeneric.class.getName()).log(Level.SEVERE, null, ex);
        } finally
       {
        tx.commit();
        sesion.clear();
        sesion.close();
       }
       
       return object;
   }    
   
   public List<?> getByCondition(Class<?> classObject,String field,String value){
       
       List<?> results = null;
       
       try{
           initOperation();      
           Criteria criteria =  sesion.createCriteria(classObject); 
           criteria.add(Restrictions.eq(field, value));
           results = criteria.list();
           
       } catch (HibernateException  ex) {
            Logger.getLogger(DaoGeneric.class.getName()).log(Level.SEVERE, null, ex);    
        } finally
       {
        sesion.getTransaction().commit();
        sesion.clear();
        sesion.close();
       }
       
       return results;
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

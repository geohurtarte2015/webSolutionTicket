
package dao;


import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public abstract class DaoAbstract {
    
private Session sesion;
private Transaction tx;


public int SaveObject(Object object) throws HibernateException {
  
    int id=0;
    
    try{
    
        initOperation();
        id = (Integer) sesion.save(object);
        tx.commit();
        
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        throw he; 
    
    
    } finally
    {
                
        sesion.close();
    
    }
    
    
    return id;
}

public void SaveObjectManyToOne(Object object) throws HibernateException {
  
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


package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Raiz;
import pojo.Seguimiento;


public class DaoSeguimiento {
    
     private Session sesion;
    private Transaction tx;
    
    public void save(Seguimiento seguimiento ) throws HibernateException {
  
    try{     
        
        initOperation();
        sesion.persist(seguimiento);        
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
    
    public List<Seguimiento> listAll(){
       
       List<Seguimiento> seguimientos = null;
       
       try{
           initOperation();
           seguimientos= sesion.createQuery("from Seguimiento").list();           
       } finally
       {
        sesion.close();
       }
       
       return seguimientos;
   }   
    
    public Seguimiento getByIdObject(int idSeguimiento){
       Seguimiento seguimiento = null;
       try{
           
           initOperation();
           seguimiento = (Seguimiento) sesion.get(Seguimiento.class, idSeguimiento);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return seguimiento;
   }
   
    public Seguimiento update(int idSeguimiento, String descripcion){
     Seguimiento seguimiento = null;
       try{           
           initOperation();
           seguimiento = (Seguimiento) sesion.get(Seguimiento.class, idSeguimiento);  
           seguimiento.setDescripcion(descripcion);
           sesion.update(seguimiento);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return seguimiento;
   
   
   }
   
    public Seguimiento delete(int idSegumiento){
     Seguimiento seguimiento = null;
       try{           
           initOperation();
           seguimiento = (Seguimiento) sesion.get(Seguimiento.class, seguimiento);                    
           sesion.delete(seguimiento);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return seguimiento;
   
   
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

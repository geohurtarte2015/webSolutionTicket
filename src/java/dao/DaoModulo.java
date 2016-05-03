package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Impacto;
import pojo.Modulo;
import pojo.ServicioModulo;
import pojo.Ticket;



public class DaoModulo {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Modulo modulo) throws HibernateException {
  
    try{  
        initOperation();
        sesion.persist(modulo);        
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
    
    public List<Modulo> listAll(){
       
       List<Modulo> modulos = null;
       
       try{
           initOperation();
           modulos= sesion.createQuery("from Modulo").list();           
       } finally
       {
        sesion.close();
       }
       
       return modulos;
   }   
    
      
    public Modulo getByIdObject(int idModulo){
       Modulo modulo = null;
       try{
           
           initOperation();
           modulo = (Modulo) sesion.get(Modulo.class, idModulo);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return modulo;
   }
   
    public Modulo update(int idModulo, String descripcion){
     Modulo modulo = null;
       try{           
           initOperation();
           modulo = (Modulo) sesion.get(Modulo.class, idModulo);  
           modulo.setDescripcion(descripcion);
           sesion.update(tx);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return modulo;
   
   
   }
   
    public Modulo delete(int idModulo){
     Modulo modulo = null;
       try{           
           initOperation();
           modulo = (Modulo) sesion.get(Modulo.class, idModulo);                    
           sesion.delete(modulo);
           tx.commit();
 
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return modulo;
   
   
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

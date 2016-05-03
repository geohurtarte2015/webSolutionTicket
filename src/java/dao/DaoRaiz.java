
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Impacto;
import pojo.Modulo;
import pojo.Raiz;



public class DaoRaiz  {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Raiz raiz ) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(raiz);        
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
    
    public List<Raiz> listAll(){
       
       List<Raiz> raices = null;
       
       try{
           initOperation();
           raices= sesion.createQuery("from Raiz").list();           
       } finally
       {
        sesion.close();
       }
       
       return raices;
   }   
    
    public Raiz getByIdObject(int idRaiz){
       Raiz raiz = null;
       try{
           
           initOperation();
           raiz = (Raiz) sesion.get(Raiz.class, idRaiz);  
           sesion.update(raiz);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return raiz;
   }
   
    public Raiz update(int idRaiz, String descripcion){
     Raiz raiz = null;
       try{           
           initOperation();
           raiz = (Raiz) sesion.get(Raiz.class, idRaiz);  
           raiz.setDescripcion(descripcion);
           sesion.update(tx);
           tx.commit();
           
       }catch(HibernateException he){
           
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return raiz;
   
   
   }
   
    public Raiz delete(int idRaiz){
     Raiz raiz = null;
       try{           
           initOperation();
           raiz = (Raiz) sesion.get(Raiz.class, idRaiz);                    
           sesion.delete(raiz);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return raiz;
   
   
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

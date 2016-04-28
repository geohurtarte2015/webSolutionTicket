
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Impacto;


public class DaoImpacto  {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Impacto impacto ) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(impacto);        
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
    
    public List<Impacto> listAll(){
       
       List<Impacto> impactos = null;
       
       try{
           initOperation();
           impactos= sesion.createQuery("from Impacto").list();           
       } finally
       {
        sesion.close();
       }
       
       return impactos;
   }   
    
    public Impacto getOne(int idImpacto){
       Impacto impacto = null;
       try{
           
           initOperation();
           impacto = (Impacto) sesion.get(Impacto.class, idImpacto);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return impacto;
   }
   
    public Impacto update(int idImpacto, String descripcion){
     Impacto impacto = null;
       try{           
           initOperation();
           impacto = (Impacto) sesion.get(Estado.class, idImpacto);  
           impacto.setDescripcion(descripcion);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return impacto;
   
   
   }
   
    public Impacto delete(int idImpacto){
     Impacto impacto = null;
       try{           
           initOperation();
           impacto = (Impacto) sesion.get(Impacto.class, idImpacto);                    
           sesion.delete(impacto);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return impacto;
   
   
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

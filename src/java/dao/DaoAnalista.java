
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Analista;

public class DaoAnalista {
    
    
   private Session sesion;
    private Transaction tx;
    
   public void save(Analista analista) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(analista);        
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
   
   public List<Analista> listAll(){
       
       List<Analista> analistas = null;
       
       try{
           initOperation();
           analistas= sesion.createQuery("from Analista").list();           
       } finally
       {
        sesion.close();
       }
       
       return analistas;
   }   
   

           
   public Analista getOne(int idAnalista){
       Analista analista = null;
       try{
           
           initOperation();
           analista = (Analista) sesion.get(Analista.class, idAnalista);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return analista;
   }
   
   public Analista update(int idAnalista, String nombre, String apellido, String password, String usuario){
     Analista analista = null;
       try{           
           initOperation();
           analista = (Analista) sesion.get(Analista.class, idAnalista);  
           analista.setNombre(nombre);
           analista.setApellido(apellido);
           analista.setUsuario(usuario);
           analista.setPassword(password);           
           sesion.update(analista);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return analista;
   
   
   }
   
    public Analista delete(int idAnalista){
     Analista analista = null;
       try{           
           initOperation();
           analista = (Analista) sesion.get(Analista.class, idAnalista);                    
           sesion.delete(analista);
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return analista;
   
   
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


package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
           
   public Analista getByIdObject(int idAnalista){
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
   
   public List<Analista> getByCondition(String field, String value){
       
       List<Analista> results = null;
       
      try{
           
           initOperation();
           Criteria analista =  sesion.createCriteria(Analista.class);  
           analista.add(Restrictions.eq(field,value));
            results = analista.list();
           
          
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
     
       }
     
     
      return results;
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
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
    
       }
       
       
       return analista;
   
   
   }
   
    public String delete(int idAnalista){
     Analista analista = null;
     String resp=null;
       try{           
           initOperation();
           analista = (Analista) sesion.get(Analista.class, idAnalista);                    
           sesion.delete(analista);
           tx.commit();
           resp="ok";
       }catch(HibernateException he){            
            resp=he.toString(); 
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

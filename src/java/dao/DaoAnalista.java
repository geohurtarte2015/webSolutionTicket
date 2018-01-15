
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
        sesion.getTransaction().commit();
        sesion.clear();
        sesion.close();
        
    
    }catch(HibernateException he)
    {
        
        trueExcepcion(he); 
        throw he; 
    
    
    } finally
    {
                
        
    
    }
    
    

}
   
   public List<Analista> listAll(){
       
       List<Analista> analistas = null;
       
       try{
           initOperation();
           analistas= sesion.createQuery("from Analista").list(); 
           sesion.getTransaction().commit();
           sesion.clear();
           sesion.close();
           int size = analistas.size();
           for(int i=0;i<size;i++){             
               System.out.println(analistas.get(i).getIdAnalista());
               System.out.println(analistas.get(i).getApellido());
               System.out.println(analistas.get(i).getNombre());               
               System.out.println(analistas.get(i).getPassword());
               System.out.println(analistas.get(i).getUsuario());
                System.out.println("\n");
           }
           
       } finally
       {
        //sesion.getTransaction().commit();
        //sesion.clear();
        //sesion.close();
        
       }
       
       return analistas;
   }      
           
   public Analista getByIdObject(int idAnalista){
       Analista analista = null;
       try{
           
           initOperation();
           analista = (Analista) sesion.get(Analista.class, idAnalista); 
           sesion.getTransaction().commit();
           sesion.clear();
           sesion.close();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
          
        //sesion.getTransaction().commit();
        //sesion.clear();
        //sesion.close();
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
           
        sesion.getTransaction().commit();
        sesion.clear();
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
           sesion.getTransaction().commit();
           sesion.clear();
           sesion.close();
           resp="ok";
       }catch(HibernateException he){            
            resp=he.toString(); 
       } finally {

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

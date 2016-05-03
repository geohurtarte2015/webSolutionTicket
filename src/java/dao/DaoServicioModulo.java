/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Estado;
import pojo.Seguimiento;
import pojo.Servicio;
import pojo.ServicioModulo;


public class DaoServicioModulo{
    
    private Session sesion;
    private Transaction tx;
    
    public void save(ServicioModulo servicioModulo) throws HibernateException {
  
    try{     
  
        initOperation();
        sesion.persist(servicioModulo);        
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
    
    public List<ServicioModulo> listAll(){
       
       List<ServicioModulo> servicioModulos = null;
       
       try{
           initOperation();
           servicioModulos= sesion.createQuery("from ServicioModulo").list();           
       } finally
       {
        sesion.close();
       }
       
       return servicioModulos;
   }   
    
    public ServicioModulo getByIdObject(int idServicioModulo){
       ServicioModulo servicioModulo = null;
       try{
           
           initOperation();
           servicioModulo = (ServicioModulo) sesion.get(ServicioModulo.class, idServicioModulo);           
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicioModulo;
   }
   
    public ServicioModulo update(int idServicioModulo, String descripcion){
     ServicioModulo servicioModulo = null;
       try{           
           initOperation();
           servicioModulo = (ServicioModulo) sesion.get(ServicioModulo.class, idServicioModulo);  
           servicioModulo.setDescripcion(descripcion);
           sesion.update(servicioModulo);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicioModulo;
   
   
   }
   
    public ServicioModulo delete(int idServicioModulo){
     ServicioModulo servicioModulo = null;
       try{           
           initOperation();
           servicioModulo = (ServicioModulo) sesion.get(ServicioModulo.class, idServicioModulo);                    
           sesion.delete(servicioModulo);
           tx.commit();
       }catch(HibernateException he){
       
        trueExcepcion(he); 
        throw he; 
       
       } finally {
           
           sesion.close();
       }
       
       
       return servicioModulo;
   
   
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

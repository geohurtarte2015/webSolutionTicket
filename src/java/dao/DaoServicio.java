
package dao;

import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Modulo;
import pojo.Servicio;
import pojo.ServicioModulo;

public class DaoServicio  {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Servicio servicio, int idModulo, int idServicioModulo) throws HibernateException {
  
    try{
        
         Modulo modulo = 
        (Modulo)sesion.get(Modulo.class, idModulo); 
             
        ServicioModulo servicioModulo = 
        (ServicioModulo)sesion.get(ServicioModulo.class, idServicioModulo); 
        
        modulo.setServicioModulo(servicioModulo);
        servicio.setModulo(modulo);
        
        initOperation();
        
        sesion.persist(servicioModulo);
        sesion.persist(modulo);
        sesion.persist(servicio);        
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

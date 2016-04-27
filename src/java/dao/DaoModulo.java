package dao;

import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Modulo;
import pojo.ServicioModulo;
import pojo.Ticket;



public class DaoModulo {
    
    private Session sesion;
    private Transaction tx;
    
    public void save(Modulo modulo,int idServicioModulo) throws HibernateException {
  
    try{     
        ServicioModulo servicioModulo = 
            (ServicioModulo)sesion.get(ServicioModulo.class, idServicioModulo); 
        
      
        initOperation();
        
        modulo.setServicioModulo(servicioModulo);
        
        
        sesion.persist(servicioModulo);
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

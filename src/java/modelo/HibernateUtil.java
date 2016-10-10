package modelo;

import org.hibernate.SessionFactory;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.internal.SessionFactoryImpl;
 
public class HibernateUtil {
     
    private static final SessionFactory sessionFactory;
     
    static{
        try{
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();         
            
        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }   
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    private void closeSessionFactory(SessionFactory factory) { 
   if(factory instanceof SessionFactoryImpl) {
      SessionFactoryImpl sf = (SessionFactoryImpl)factory;
      ConnectionProvider conn = sf.getConnectionProvider();
      if(conn instanceof C3P0ConnectionProvider) { 
        ((C3P0ConnectionProvider)conn).close(); 
      }
   }
   factory.close();
}
     
}
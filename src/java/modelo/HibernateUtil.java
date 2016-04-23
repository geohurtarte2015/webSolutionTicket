package modelo;

import static com.mchange.v2.log.MLog.config;
import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
    
    Session session;
    Statement st;
    Configuration config;
     
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
    
    public Configuration getConfiguration(){
    return config;
    }
     
    public Session getSession(){
    return session;
    }
    
  
     
}
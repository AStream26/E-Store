package com.project.myshop.helper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class SessionFactoryProvider {
    
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        
        try{
           if(sessionFactory == null){
                Configuration cfg = new Configuration();
                cfg.configure();
                sessionFactory= cfg.buildSessionFactory();
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
    
    public static void closeSession(SessionFactory factory,Session session){
        
        try{
            if(session != null){
                session.close();
            }
                                                                                                                            
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
    }
    
}

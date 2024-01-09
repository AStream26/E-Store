package com.project.myshop.dao;

import com.project.myshop.enums.Status;
import com.project.myshop.helper.PasswordEncryptionUtil;
import com.project.myshop.helper.SessionFactoryProvider;
import com.project.myshop.model.User;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao implements IDao {
    
    private Session session = null;
    
     public Status save(Object user){
         
         user = (User)user;
         Transaction transaction = null;
         SessionFactory factory = null;
         boolean flag = false;
         try{
             factory = SessionFactoryProvider.getSessionFactory();
             session = factory.openSession();
             transaction = session.beginTransaction();
             
             session.persist(user);
             flag = true;
         }
         catch(Exception exp){
             
            throw exp;
         }
         finally{
             
             if(flag){
                 transaction.commit();
             }
             else{
                 transaction.rollback();
             }
             
             SessionFactoryProvider.closeSession(factory, session);
         }
        
        return Status.SUCCESS;
    }
    
    public User getById(Object userId){
        
        userId = (Integer)userId;
        SessionFactory factory = null;
        User user = null;
        try{
            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();
            
            user = session.get(User.class,userId);
            
            return user;
        }
        catch(Exception exp){
            System.err.println("Error = "+ exp.getMessage());
        }
        
        return user;
    }
    
    public User getUserByEmail(String email){
        
         Transaction transaction = null;
         SessionFactory factory = null;
         User user = null;
         try{
             factory = SessionFactoryProvider.getSessionFactory();
             session = factory.openSession();
             
             
             Query query  = session.createQuery("FROM User WHERE email =:email",User.class);
             query.setParameter("email", email);
             List<User> userList = query.getResultList();
             
             if(userList.size() !=0){
                 user = userList.get(0);
             }
            
         }
         catch(Exception exp){
             exp.printStackTrace();
            
         }
         finally{
             
             SessionFactoryProvider.closeSession(factory, session);
         }
         return user;
    }
    public Status updateById(Object user){return null;}
    public Status deleteById(Object user){return  null;}
}

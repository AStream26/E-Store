package com.project.myshop.dao;

import com.project.myshop.enums.Status;
import com.project.myshop.helper.PasswordEncryptionUtil;
import com.project.myshop.helper.SessionFactoryProvider;
import com.project.myshop.model.User;
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
             exp.printStackTrace();
             return Status.FAILURE;
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
    
    public User getById(Object user){
        
        return null;
    }
    public Status updateById(Object user){return null;}
    public Status deleteById(Object user){return  null;}
}

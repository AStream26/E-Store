package com.project.myshop.service;


import com.project.myshop.dao.IDao;
import com.project.myshop.dao.UserDao;
import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Service;
import com.project.myshop.model.User;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.DaoFactoryProvider;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.helper.PasswordEncryptionUtil;

public class UserServiceImpl implements IService {
    
    
    
    public Status save(Object obj){
        
        try{
            User user = (User)obj;
        String password = PasswordEncryptionUtil.encryptPassword(user.getPassword());
        user.setPassword(password);
        
        return DaoFactoryProvider.getDao(Dao.USER_DAO).save(user);
        }
        catch(Exception exp){
            throw exp;
        }
    }
    
    public User getUserById(Object obj){
        
        return null;
    }
    public Status updateUserById(Object obj){return null;}
    public Status deleteUserById(Object obj){return  null;}
    
    public  User getUserByEmailAndPwd(String email,String pwd){
        
        IDao dao = DaoFactoryProvider.getDao(Dao.USER_DAO);
        UserDao userDao = (UserDao)dao;
        User user = userDao.getUserByEmail(email);
        
        if(user == null || !PasswordEncryptionUtil.checkPassword(pwd, user.getPassword()))return null;  
        return user;
    }
}

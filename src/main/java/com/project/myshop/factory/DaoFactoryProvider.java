package com.project.myshop.factory;

import com.project.myshop.dao.IDao;
import com.project.myshop.dao.UserDao;
import com.project.myshop.enums.Dao;
public class DaoFactoryProvider {
    
    private static  IDao daoImpl = null;
    
    private DaoFactoryProvider(){   
    }
    
    public static IDao getDao(Dao dao){
        
        if(dao.USER_DAO == Dao.USER_DAO){
            
           daoImpl= new UserDao();
        }
        
        return daoImpl;
    }    
}

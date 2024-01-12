package com.project.myshop.factory;

import com.project.myshop.dao.CategoryDao;
import com.project.myshop.dao.IDao;
import com.project.myshop.dao.UserDao;
import com.project.myshop.enums.Dao;
public class DaoFactoryProvider {
    
    private static  IDao daoImpl = null;
    
    private DaoFactoryProvider(){   
    }
    
    public static IDao getDao(Dao dao){
        
        if(Dao.USER_DAO == dao){
            
           daoImpl= new UserDao();
        }
        else if(Dao.CATEGORY_DAO == dao)
                daoImpl = new CategoryDao();
        
        return daoImpl;
    }    
}

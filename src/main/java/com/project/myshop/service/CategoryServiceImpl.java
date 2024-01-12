package com.project.myshop.service;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.DaoFactoryProvider;
import com.project.myshop.model.Category;

public class CategoryServiceImpl implements IService<Category> {
    
    
    
    public Status save(Object category){
        
        return DaoFactoryProvider.getDao(Dao.CATEGORY_DAO).save(category);
      
    }
    
    public Status updateById(Object obj){return null;}
    public Status deleteById(Object obj){return  null;}
    
}

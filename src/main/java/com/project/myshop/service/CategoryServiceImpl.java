package com.project.myshop.service;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.DaoFactoryProvider;
import com.project.myshop.model.Category;
import java.util.List;

public class CategoryServiceImpl implements IService<Category> {
    
    
    
    public Status save(Category category){
        
        return DaoFactoryProvider.getDao(Dao.CATEGORY_DAO).save(category);
      
    }
    
    public Status updateById(Object obj){return null;}
    public Status deleteById(Object obj){return  null;}
    
    public List<Category> find(String queryCondition,String queryValue,Class<Category> inputClass){
        return DaoFactoryProvider.getDao(Dao.CATEGORY_DAO).find(queryCondition, queryValue, inputClass);
    }
    
}

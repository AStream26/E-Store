package com.project.myshop.service;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.DaoFactoryProvider;
import com.project.myshop.model.Product;

public class ProductServiceImpl implements IService<Product> {
    
    
    
    public Status save(Product product){
        
        return DaoFactoryProvider.getDao(Dao.CATEGORY_DAO).save(product);
      
    }
    
    public Status updateById(Object obj){return null;}
    public Status deleteById(Object obj){return  null;}
    
}

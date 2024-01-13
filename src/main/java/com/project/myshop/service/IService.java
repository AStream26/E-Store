package com.project.myshop.service;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.DaoFactoryProvider;
import java.util.List;


public interface IService<Model> {
    Status save(Model model);
    default Model findById(Class<Model> inputClass,Integer id,Dao dao){
        
        return (Model)DaoFactoryProvider.getDao(dao).findById(inputClass, id);
    }
    Status updateById(Object obj);
    Status deleteById(Object obj);
    default List<Model> findAll(Class<Model> inputClass,Dao dao){
        return DaoFactoryProvider.getDao(dao).findAll(inputClass);
    }
    
    List<Model> find(String queryCondition,String queryValue,Class<Model> inputClass);
}

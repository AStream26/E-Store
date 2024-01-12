    package com.project.myshop.factory;

import com.project.myshop.enums.Service;
import com.project.myshop.service.CategoryServiceImpl;
import com.project.myshop.service.IService;
import com.project.myshop.service.UserServiceImpl;

public class ServiceFactoryProvider {
   
    
    private ServiceFactoryProvider(){
        
    }
    
    public static IService getService(Service service){
       
       if(Service.USER_SERVICE == service){
           
           return new UserServiceImpl();
       }
       else if(service.CATEGORY_SERVICE == service)
                return new CategoryServiceImpl();
       
       return null;
    }
}

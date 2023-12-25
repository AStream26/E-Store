package com.project.myshop.service;

import com.project.myshop.enums.Status;
import com.project.myshop.model.User;


public interface IService {
    Status save(Object obj);
    User getUserById(Object obj);
    Status updateUserById(Object obj);
    Status deleteUserById(Object obj);
}

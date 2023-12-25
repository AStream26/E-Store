package com.project.myshop.dao;

import com.project.myshop.enums.Status;
import com.project.myshop.model.User;

public interface IDao {
    Status save(Object obj);
    User getById(Object obj);
    Status updateById(Object obj);
    Status deleteById(Object obj);
}

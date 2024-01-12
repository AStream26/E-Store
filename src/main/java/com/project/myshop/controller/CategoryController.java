package com.project.myshop.controller;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Service;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.model.Category;
import com.project.myshop.service.IService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "CategoryController", urlPatterns = {"/category/*"})
public class CategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Category category = null;
        String path = request.getRequestURI();
        if (path.endsWith("/category")) {
            category= new Category();
            category.setCategoryName(request.getParameter("cName"));
            category.setDescription(request.getParameter("cDesp"));

            IService service = ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE);
            Status status = service.save(category);
            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");      
            request.setAttribute("messageFrom", "admin");
            if (status.SUCCESS == status) {
                List<Category> categoryList = ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE).findAll(Category.class, Dao.CATEGORY_DAO);
                session.setAttribute("categoryList", categoryList);
                request.setAttribute("message", category.getCategoryName() + " Category Added successfully");
                request.setAttribute("type", "success");
               
            } else {

                request.setAttribute("message", category.getCategoryName() + "failed to add");
                request.setAttribute("type", "failure");
            }
            dispatcher.include(request, response);      
        }      
    }

    @Override
    public String getServletInfo() {
        return "Category Managamement";
    }

}

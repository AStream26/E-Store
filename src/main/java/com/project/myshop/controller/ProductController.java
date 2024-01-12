package com.project.myshop.controller;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Service;
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
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = {"/product/*"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("I am testing kk " + request.getRequestURI());
        String path = request.getRequestURI();
        try {

            if (path.endsWith("/category")) {
                IService service = ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE);
                List<Category> category = service.findAll(Category.class, Dao.USER_DAO);
                System.out.println(category.get(0).toString());
            }
            
            else if(path.endsWith("/product")){
                System.out.println("******************");
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception exp) {
               System.out.println(exp.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Product Managamement";
    }

}

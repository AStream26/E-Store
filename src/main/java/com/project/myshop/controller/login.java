package com.project.myshop.controller;

import com.project.myshop.enums.Service;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.model.User;
import com.project.myshop.service.IService;
import com.project.myshop.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        try{
            
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            
            IService service = ServiceFactoryProvider.getService(Service.USER_SERVICE);
            
            User user = ((UserServiceImpl)service).getUserByEmail(email);
            
            if(user != null){
                System.out.println(user);
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("message", "Email or Password is incorrect!!");
                request.setAttribute("type", "failure");
                dispatcher.forward(request, response);
                
            }
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package com.project.myshop.controller;

import com.project.myshop.enums.Service;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.helper.JWTUtil;
import com.project.myshop.model.User;
import com.project.myshop.service.IService;
import com.project.myshop.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        Cookie[] cookie1 = request.getCookies();
        System.out.println("Avi Sri " + cookie1[0]);
        
        if(cookie1 != null){
            System.out.println(cookie1[0].getValue());
        }
        try{
            
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            
            IService service = ServiceFactoryProvider.getService(Service.USER_SERVICE);
            
            User user = ((UserServiceImpl)service).getUserByEmailAndPwd(email,password);
            
            if(user != null){
                System.out.println(user);
                
                String token = JWTUtil.createJWT(user.getId().toString(), 300000);
                System.out.println(token);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);   
                 response.sendRedirect("/MyShop");
                
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

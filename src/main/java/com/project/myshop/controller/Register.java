
package com.project.myshop.controller;

import com.project.myshop.enums.Role;
import com.project.myshop.enums.Service;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.model.User;
import com.project.myshop.service.IService;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author avikr
 */
@WebServlet("/signup")
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println(request.getRequestURI());
        
        try{
            
            String name = request.getParameter("uname");
            String mobileNo = request.getParameter("mobNo");
            String email = request.getParameter("email");
            String password = request.getParameter("pwd");
            
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setMobileNo(mobileNo);
            user.setPassword(password);
            user.setRole(Role.USER);
            user.setImage("default.jpg");
            IService service = ServiceFactoryProvider.getService(Service.USER_SERVICE);
            
            Status status = service.save(user);
            
            if(status == Status.SUCCESS){
                System.out.println("User Created!!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("message", "account created . login to continue");
                request.setAttribute("type", "succcess");
                dispatcher.forward(request, response);
            }
            else {
                System.err.println("User creation Failed!!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                request.setAttribute("message", "account cannot be created");
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

package com.project.myshop.controller;

import com.project.myshop.enums.Role;
import com.project.myshop.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebFilter(filterName = "CheckAdmin", urlPatterns = {"/admin/*"})
public class CheckAdmin extends HttpFilter implements Filter{
    
    public CheckAdmin(){
        System.out.println("com.project.myshop.controller.CheckAdmin.<init>()");
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
        
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        System.out.println(httpRequest.getRequestURI());
        
        User Currentuser = (User)request.getAttribute("currentUser");
        
        if(Currentuser.getRole() != Role.ADMIN){
            
            System.err.println("Now admin Redircting.....");
            httpResponse.sendRedirect( "/MyShop/");
        }
        
        else{
             chain.doFilter(request, response);
        }
        
    }
   
    public void init(FilterConfig config){
        System.out.println("From the checkadmin config");
    }
}

package com.project.myshop.controller;

import com.nimbusds.jwt.JWTClaimsSet;
import com.project.myshop.enums.Service;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.helper.JWTUtil;
import com.project.myshop.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/*"})
public class AuthorizationFilter extends HttpFilter implements Filter{
    
    public AuthorizationFilter(){
        System.out.println("com.project.myshop.controller.AuthorizationFilter.<init>()");
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        System.out.println(httpRequest.getRequestURI());
        
        Cookie[] cookies = httpRequest.getCookies();
      //  System.out.println(cookies.length);
       if(cookies != null){
           
            for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                System.out.println("Cookie Value is " + cookie.getValue());
                JWTClaimsSet claimSet = JWTUtil.parseJWT(cookie.getValue());
                
                System.out.println(claimSet);
                if(claimSet != null && JWTUtil.isValid(claimSet)){
                    Integer userId =Integer.parseInt( claimSet.getSubject());
                    System.out.println("user Id = " + userId);
                    
                    if(request.getAttribute("currentUser") == null){
                        User currentUser = ServiceFactoryProvider.getService(Service.USER_SERVICE).getById(userId);
                        System.out.println(currentUser);
                        request.setAttribute("currentUser", currentUser);
                    }    
                    
                }
                else{
                    System.err.println("Expired");
                }
            }
        }
       }else{
           System.out.println("Cookie expried...");
            
       }
        chain.doFilter(request, response);
        
    }
   
    public void init(FilterConfig config){
        System.out.println("From the config");
    }
}

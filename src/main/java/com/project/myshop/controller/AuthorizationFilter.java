package com.project.myshop.controller;

import com.nimbusds.jwt.JWTClaimsSet;
import com.project.myshop.helper.JWTUtil;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"/*"})
public class AuthorizationFilter extends HttpFilter implements Filter{
    
    public AuthorizationFilter(){
        System.out.println("com.project.myshop.controller.AuthorizationFilter.<init>()");
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        System.out.println(httpRequest.getRequestURI());
        
        Cookie[] cookies = httpRequest.getCookies();
       
       if(cookies != null){
           
            for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                System.out.println("Cookie Value is " + cookie.getValue());
                JWTClaimsSet claimSet = JWTUtil.parseJWT(cookie.getValue());
                
                System.out.println(claimSet);
                if(claimSet != null && JWTUtil.isValid(claimSet)){
                    Integer userId =Integer.parseInt( claimSet.getSubject());
                    System.out.println("user Id = " + userId);
                    request.setAttribute("userId", userId);
                }
            }
        }
       }
        chain.doFilter(request, response);
        
    }
   
    public void init(FilterConfig config){
        System.out.println("From the config");
    }
}

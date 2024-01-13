package com.project.myshop.controller.Filter;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Service;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.model.Category;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@WebFilter(filterName = "categoryFilter", urlPatterns = {"/product/*"})
public class CategoryFilter extends HttpFilter implements Filter{
   private FilterConfig filterConfig;
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException{
        
        ServletContext context = filterConfig.getServletContext();
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        List<Category> categories = ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE).findAll(Category.class, Dao.CATEGORY_DAO);
        context.setAttribute("categoryList", categories);
        chain.doFilter(request, response);
    }
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
   
}

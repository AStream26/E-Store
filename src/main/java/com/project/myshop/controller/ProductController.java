package com.project.myshop.controller;

import com.project.myshop.enums.Dao;
import com.project.myshop.enums.Service;
import com.project.myshop.enums.Status;
import com.project.myshop.factory.ServiceFactoryProvider;
import com.project.myshop.helper.FileUploadUtil;
import com.project.myshop.model.Category;
import com.project.myshop.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ProductController", urlPatterns = {"/product/*"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        //System.out.println();
        if (request.getPathInfo() == null) {
            
            List<Product> products = ServiceFactoryProvider.getService(Service.PRODUCT_SERVICE).findAll(Product.class, Dao.PRODUCT_DAO);
            List<Category> categories = ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE).findAll(Category.class, Dao.CATEGORY_DAO);
            context.setAttribute("productList", products);
            context.setAttribute("categoryList", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
            dispatcher.forward(request, response);
            
        } else {
            String[] pathInfo = request.getPathInfo().replaceAll("^/|/$", "").split("/");
            System.out.println(pathInfo.toString());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.endsWith("/product")) {
            Product product = new Product();
            product.setDescription(request.getParameter("pDesp"));
            product.setName(request.getParameter("pName"));
            product.setPrice(Double.valueOf(request.getParameter("pPrice")));
            product.setQuantity(Integer.valueOf(request.getParameter("pQuantity")));

            Integer cId = Integer.valueOf(request.getParameter("pCategory"));
            Category category = (Category) ServiceFactoryProvider.getService(Service.CATEGORY_SERVICE).findById(Category.class, cId, Dao.CATEGORY_DAO);
            System.out.println(category.toString());
            product.setCategory(category);
            Part part = request.getPart("pImage");
            product.setImage(part.getSubmittedFileName());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
            System.out.println(product.toString());
            boolean isImageUploaded = FileUploadUtil.uploadImage(part, getServletContext());

            if (!isImageUploaded) {
                request.setAttribute("message", product.getName() + " Image failed to upload");
                request.setAttribute("type", "failure");
            }

            if (isImageUploaded) {
                Status status = ServiceFactoryProvider.getService(Service.PRODUCT_SERVICE).save(product);

                if (status.SUCCESS == status) {
                    request.setAttribute("message", product.getName() + " Product Added successfully");
                    request.setAttribute("type", "success");

                } else {
                    request.setAttribute("message", product.getName() + "failed to add");
                    request.setAttribute("type", "failure");
                }
            }
            dispatcher.include(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Product Managamement";
    }

}

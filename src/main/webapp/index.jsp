<%-- 
    Document   : main.jsp
    Created on : 17-Dec-2023, 1:49:51 am
    Author     : avikr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.project.myshop.helper.SessionFactoryProvider" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyShop</title>
        
        <%@include file="components/common.jsp" %>
    </head>
    <body>
        <h1>FactoryProvider</h1>
       
        <%
            out.println(SessionFactoryProvider.getSessionFactory());
         %>
    </body>
</html>

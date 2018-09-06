<%-- 
    Document   : Login.jsp
    Created on : Sep 6, 2018, 1:25:07 AM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>
        <header><h1>Login</h1></header>
        <form action="Login" method="get">
            <label>Username</label>
            <input type="text" name ="username"><br>
            <label>Password</label>
            <input type ="password" name ="password"><br>
            <input type ="hidden" name="action" value ="login">
            <input type="submit" value="Login">
        </form>
        <br>
        <nav>
            <a href="New_customer.jsp">New Customer Sign Up Page</a> <br>
            <a href="password_reset.jsp">Reset Password</a>
        </nav>
    <c:import url = "footer.jsp"/>
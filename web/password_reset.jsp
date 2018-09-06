<%-- 
    Document   : password_reset
    Created on : Sep 4, 2018, 7:45:03 PM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>
        <h1>Reset Password</h1>
        <p><b>${message}</b></p>
        <form action="PasswordReset" method ="post">
            <label>Old Password</label>
            <input type="text" name="oldPassword" value ="${user.password}"><br>
            <label>New Password</label>
            <input type ="text" name="newPassword"><br>
            <input type="hidden" name="action" value ="newpass">
            <input type="submit" value ="Submit">
        </form> 
  <c:import url = "footer.jsp"/>
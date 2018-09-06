<%-- 
    Document   : Account_activity
    Created on : Sep 6, 2018, 1:30:12 AM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>
        <header><h1>Account Activity</h1></header>
        
        <c:if test="${user != null}"> Welcome: ${user.firstName} ${user.lastName}</c:if>
        <c:if test="${user == null}"> Not Logged In</c:if>
        
    <c:import url = "footer.jsp"/>
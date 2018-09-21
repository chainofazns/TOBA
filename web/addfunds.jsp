<%-- 
    Document   : addfunds
    Created on : Sep 20, 2018, 6:52:42 PM
    Author     : Leo
--%>

<%@page import="toba.AccountDB"%>
<%@page import="toba.Account"%>
<%@page import="toba.TOBAUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>
    
    <header>Add Funds</header>
       <%
        TOBAUser user =(TOBAUser) session.getAttribute("user");
        Account account = AccountDB.getAccount(user.getUserId());
        double balance = account.getBalance();
        request.setAttribute("balance", balance);
       %>
    <form action="AddFunds" method ="post">
        <label> Balance: ${balance}</label> <br>
        <label> Deposit:</label>
        <input type ="number" name="delta"> <br>
        <input type ="hidden" name="action" value="deposit">
        <input type="submit" value="Submit"> 
    </form>
    
    
<c:import url = "footer.jsp"/>
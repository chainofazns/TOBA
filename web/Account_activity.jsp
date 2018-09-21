<%-- 
    Document   : Account_activity
    Created on : Sep 6, 2018, 1:30:12 AM
    Author     : Leo
--%>

<%@page import="toba.AccountDB"%>
<%@page import="java.util.List"%>
<%@page import="toba.Account"%>
<%@page import="toba.TOBAUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>
        <header><h1>Account Activity</h1></header>
        <%
            TOBAUser user =(TOBAUser) session.getAttribute("user");
            Account account = AccountDB.getAccount(user.getUserId());
            List tList = account.getTransactions();
            double balance = account.getBalance();
            request.setAttribute("balance", balance);
            request.setAttribute("tList", tList);            
        %>
        <c:if test="${user != null}"> Welcome: ${user.firstName} ${user.lastName}</c:if>
        <c:if test="${user == null}"> Not Logged In</c:if>
        <br> <label> Balance: ${balance}</label> <br><br><br>
        <table>
            <tr>
                <td>Balance: </td>
                <td>Added: </td>
            </tr>
            <c:forEach items="${tList}" var = "transaction">
                <tr>
                    <td>$<c:out value="${transaction.balance}"/></td>
                    <td>$<c:out value="${transaction.delta}"/></td>
                </tr>
                
            </c:forEach>
            
            
        </table>
        
    <c:import url = "footer.jsp"/>
<%-- 
    Document   : New_customer
    Created on : Aug 21, 2018, 3:08:08 PM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:import url="/header.html"/>

        <header><h1>New Customer</h1></header>
        <div>
            Please out all the information below <br>
            <p><b>${message}</b></p>
        </div>
        
        <form action="NewCustomer" method ="post">
            <label>First Name</label>
            <input type="text" name =firstName value="${user.firstName}"><br>
            <label>Last Name</label>
            <input type="text" name ="lastName" value="${user.lastName}"><br>
            <label>Phone Number</label>
            <input type="text" name ="phone" value="${user.phone}"><br>
            <label>Address</label>
            <input type="text" name ="address" value="${user.address}"><br>
            <label>City</label>
            <input type="text" name ="city" value="${user.city}"><br>
            <label>State</label>
            <input type="text" name ="state" value="${user.state}"><br>
            <label>Zip Code</label>
            <input type="text" name ="zipcode" value="${user.zipcode}"><br>
            <label>Email</label>
            <input type="email" name ="email" value="${user.email}"><br>
            <input type ="hidden" name="action" value ="register">
            <input type="submit" value="Submit">
        </form>
        
        <c:import url = "footer.jsp"/>
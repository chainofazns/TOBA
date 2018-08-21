<%-- 
    Document   : New_customer
    Created on : Aug 21, 2018, 3:08:08 PM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TOBA: New Customer</title>
    </head> 
    <body>
        <header><h1>New Customer</h1></header>
        <div>
            Please out all the information below <br>
            <p><b>${message}</b></p>
        </div>
        
        <form action="NewCustomer" method ="post">
            <label>First Name</label>
            <input type="text" name =firstName><br>
            <label>Last Name</label>
            <input type="text" name ="lastName"><br>
            <label>Phone Number</label>
            <input type="text" name ="phone"><br>
            <label>Address</label>
            <input type="text" name ="address"><br>
            <label>City</label>
            <input type="text" name ="city"><br>
            <label>State</label>
            <input type="text" name ="state"><br>
            <label>Zip Code</label>
            <input type="text" name ="zipcode"><br>
            <label>Email</label>
            <input type="email" name ="email"><br>
            <input type ="hidden" name="action" value ="register">
            <input type="submit" value="Submit">
        </form>
        
    </body>
</html>

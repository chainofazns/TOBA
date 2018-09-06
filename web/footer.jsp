<%-- 
    Document   : footer
    Created on : Sep 4, 2018, 5:40:34 PM
    Author     : Leo
--%>
<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<% 
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>



<p>&copy; Copyright <%= currentYear %> TOBA   </p>
    </body>
</html>

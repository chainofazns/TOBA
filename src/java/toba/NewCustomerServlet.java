package toba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Leo
 */
@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewCustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewCustomerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/New_customer.jsp";
        
        String action = request.getParameter("action");
        if (action == null){
            action = "main";           
        } 
        if (action.equals("main")){
            url = "/index.html";
        } else if (action.equals("register")) {
            //get parameters
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipcode = request.getParameter("zipcode");
            String email = request.getParameter("email");
            
            //create session
            HttpSession session = request.getSession();
            TOBAUser user = (TOBAUser) session.getAttribute("user");
            if (user == null){
                //if no user, create blank user
                user = new TOBAUser();
            }
            
            String message;
            double balance;
         //validate
            if(firstName == null || lastName == null || phone == null || address == null || 
                city == null || state == null || zipcode == null || email == null || 
                firstName.isEmpty() || lastName.isEmpty() || phone .isEmpty() || address.isEmpty() || 
                city.isEmpty() ||  state.isEmpty() ||  zipcode.isEmpty() ||  email.isEmpty()
                ){
                message = "Please fill out all the text boxes";
                url = "/New_customer.jsp";
            } else {
                //all data has been filled out, so fill it out
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPhone(phone);
                user.setAddress(address);
                user.setCity(city);
                user.setState(state);
                user.setZipcode(zipcode);
                user.setEmail(email);
                user.setUsername(lastName + zipcode);
                user.setPassword("welcome1"); //defaults to welcome 1
                
                session.setAttribute("user", user);
                
                
                message = "User Created";
                url = "/Success.jsp";
                UserDB.insert(user);
                Account account = new Account(user.getUserId(), 25.00);
                AccountDB.insert(account);
            }               
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

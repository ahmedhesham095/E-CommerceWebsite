/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package header;

import daoimp.UsersDAOImp;
import dto.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Freeware Sys
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
            /* Take parameters from the request */
            String name = request.getParameter("Name");
            String email = request.getParameter("Email");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String job = request.getParameter("job");
           // Date startDate = (Date) new SimpleDateFormat("MM-DD-YYYY").parse(request.getParameter("dob"));
           String date = request.getParameter("dob");
            String credit = request.getParameter("credit");
            int creditno = Integer.parseInt(credit);
            /* Create User */
            UsersDTO user = new UsersDTO();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setAddress(address);
            user.setJob(job);
            user.setCreditLimit(creditno);
            user.setDateOfBirth(date);
            user.setIsAdmin(0);
            UsersDAOImp dao = new UsersDAOImp();
            user = dao.create(user);
            System.out.println(user.getEmail());
            System.out.println(user.getDateOfBirth());
            /* create session with that user */
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("address", user.getAddress());
                session.setAttribute("job", user.getJob());
                session.setAttribute("dob", user.getDateOfBirth());
                session.setAttribute("credit", user.getCreditLimit());
                session.setAttribute("admin", user.getIsAdmin());
//                RequestDispatcher rd = request.getRequestDispatcher("/editProfile.jsp");
//                rd.forward(request, response);
                response.sendRedirect("/Categories");
            }
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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

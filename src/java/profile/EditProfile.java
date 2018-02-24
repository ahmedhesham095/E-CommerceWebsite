/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

import daoimp.UserInterestDAOImp;
import daoimp.UsersDAOImp;
import dto.UserInterstsDTO;
import dto.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author Ali Alzantot
 */
@WebServlet(name = "EditProfile", urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

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
            out.println("<title>Servlet EditProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProfile at " + request.getContextPath() + "</h1>");
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
        /*
        
            HttpSession session = request.getSession(false);
            //response.sendRedirect("/Ecommerce/index.jsp");
            UsersDTO user=(UsersDTO) session.getAttribute("user");
            //id and is admin from session
         */
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            String address = request.getParameter("address");
            String job = request.getParameter("job");
            String birthday = request.getParameter("birthday");
            //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //  java.util.Date date = sdf.parse(birthday);
            //  java.sql.Date sqlDate = new Date(date.getTime());    
            String[] values = request.getParameterValues("interest");
            int creditLimit = Integer.parseInt(request.getParameter("credit"));
            UsersDAOImp userI = new UsersDAOImp();
             UsersDTO user = new UsersDTO();
            UserInterstsDTO interest = new UserInterstsDTO();
            UserInterestDAOImp addInter = new UserInterestDAOImp();
            interest.setUser_id(Integer.parseInt(id));
            addInter.delete(interest);
            for (String value : values) {
                interest.setUser_id(Integer.parseInt(id));
                interest.setCategory_id(Integer.parseInt(value));
                addInter.create(interest);
                
            }
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setAddress(address);
            user.setJob(job);
            user.setCreditLimit(creditLimit);
            user.setDateOfBirth(birthday);
            userI.update(user);
            request.setAttribute("done", new String("true"));
            
            HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("address", user.getAddress());
                session.setAttribute("job", user.getJob());
                session.setAttribute("dob", user.getDateOfBirth());
                session.setAttribute("credit", user.getCreditLimit());
                session.setAttribute("admin", user.getIsAdmin());
        } catch (Exception ex) {
            request.setAttribute("done", new String("false"));
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("Intersts");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

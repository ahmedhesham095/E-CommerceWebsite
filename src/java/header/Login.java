/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package header;

import daoimp.ProductsDAOImp;
import daoimp.UserProductsDAOImp;
import daoimp.UsersDAOImp;
import dto.UserProductsDTO;
import dto.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            String email = request.getParameter("Email");
            String password = request.getParameter("password");
            UsersDTO user = new UsersDTO();
            UsersDAOImp d1 = new UsersDAOImp();
            UserProductsDAOImp userProduct = new UserProductsDAOImp();
            ProductsDAOImp productDAO = new ProductsDAOImp();
            user = d1.retreiveByMailAndPass(email, password);
            HttpSession session = request.getSession();
            if (user != null) {
                
                session.setAttribute("id", user.getId());
                session.setAttribute("name", user.getName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("address", user.getAddress());
                session.setAttribute("job", user.getJob());
                session.setAttribute("dob", user.getDateOfBirth());
                session.setAttribute("credit", user.getCreditLimit());
                session.setAttribute("admin", user.getIsAdmin());
                
                ArrayList<UserProductsDTO> cart = new ArrayList<UserProductsDTO>();
                cart = userProduct.searchByStatus(user.getId(), 0);
                for (int i=0;i<cart.size();++i){
                    cart.get(i).setProduct(productDAO.retreiveById(cart.get(i).getProduct_id()));
                }
                session.setAttribute("cart", cart);
                
                session.setAttribute("error", null);
//                RequestDispatcher rd = request.getRequestDispatcher("/Home");
//                rd.forward(request, response);
//                    response.sendRedirect("Home");
                    response.sendRedirect(request.getHeader("referer"));
            } else {

                session.setAttribute("error", "Invalid Email or Password");
//                response.sendRedirect(request.getHeader("referer"));
                RequestDispatcher rd = request.getRequestDispatcher("/Categories");
                rd.include(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

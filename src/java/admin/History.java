/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import daoimp.ProductsDAOImp;
import daoimp.UserProductsDAOImp;
import daoimp.UsersDAOImp;
import dto.ProductsDTO;
import dto.UserProductsDTO;
import dto.UsersDTO;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author Nouran
 */
@WebServlet(name = "History", urlPatterns = {"/History"})
public class History extends HttpServlet {

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
            out.println("<title>Servlet History</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet History at " + request.getContextPath() + "</h1>");
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
        String idParam = request.getParameter("ID");
        int id = Integer.parseInt(idParam);
        String name ; 
        
        ProductsDAOImp productsDAO = new ProductsDAOImp();
        ArrayList<UserProductsDTO> userProducts = new ArrayList<UserProductsDTO>();
        ArrayList<String> productsName = new ArrayList<String>();
        UserProductsDAOImp userProductsDAO = new UserProductsDAOImp();
        UsersDTO user = new UsersDTO();
        UsersDAOImp userDAO = new UsersDAOImp();
        try {
            user=userDAO.retreiveByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProducts = userProductsDAO.searchByStatus(id, 1);
        
        for (int i=0 ; i< userProducts.size() ; i++) 
        {
            name=productsDAO.getName(userProducts.get(i).getProduct_id());
            productsName.add(name);  
        }
        request.setAttribute("user", user);
        System.out.println(user.getEmail());
        request.setAttribute("history", userProducts);
        request.setAttribute("productName", productsName);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/orderHistory.jsp");
        rd.forward(request, response);
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

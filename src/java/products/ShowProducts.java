/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package products;

import daoimp.CategoriesDAOImp;
import daoimp.ProductsDAOImp;
import dto.ProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shimaa
 */
public class ShowProducts extends HttpServlet {

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
        
        ArrayList<ProductsDTO> productsList = new ArrayList<ProductsDTO>();
        ProductsDAOImp pro = new ProductsDAOImp();
        CategoriesDAOImp category = new CategoriesDAOImp();
        String productsType = null;
        
        try {
           
           int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            
           if(categoryId == 0){
                productsList = pro.retreive();
                productsType = "All Products";
           }else{
                productsList = pro.searchByCategory(categoryId);
                productsType = category.searchById(categoryId).getName();
                System.out.println(productsType);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ShowProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.setAttribute("productsList", productsList);
        request.setAttribute("productsType", productsType);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/products.jsp");
        
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

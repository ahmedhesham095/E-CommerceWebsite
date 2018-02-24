/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import daoimp.UserProductsDAOImp;
import dto.UserProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "RemoveALLQuantity", urlPatterns = {"/RemoveALLQuantity"})
public class RemoveALLQuantity extends HttpServlet {

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
            out.println("<title>Servlet RemoveALLQuantity</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveALLQuantity at " + request.getContextPath() + "</h1>");
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
            ArrayList<UserProductsDTO> userProductsDTOArray;
            UserProductsDAOImp userProductsDAOImp=new UserProductsDAOImp();
            HttpSession session =request.getSession(false);
            ArrayList<UserProductsDTO> cartProducts=(ArrayList<UserProductsDTO>) session.getAttribute("cart");
            int userID=Integer.parseInt(request.getParameter("userID"));
            int productID=Integer.parseInt(request.getParameter("productId"));
            for (int i=0;i<cartProducts.size();++i){
                if(cartProducts.get(i).getUser_id()==userID && productID == cartProducts.get(i).getProduct_id() ){

                        userProductsDTOArray= userProductsDAOImp.searchByStatus(cartProducts.get(i).getUser_id(),0);
                        for (int j=0;j<userProductsDTOArray.size();++j){
                            if (userProductsDTOArray.get(j).getProduct_id()==cartProducts.get(i).getProduct_id()){
                                userProductsDAOImp.delete(cartProducts.get(i));
                                break;
                            }
                        }
                        
                        cartProducts.remove(i);
                    
                    break;
                }
            }

            session.setAttribute("remove",new String("success"));
            response.sendRedirect(request.getHeader("referer"));
            
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

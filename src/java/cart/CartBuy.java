/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import daoimp.ProductsDAOImp;
import daoimp.UserProductsDAOImp;
import daoimp.UsersDAOImp;
import dto.ProductsDTO;
import dto.UserProductsDTO;
import dto.UsersDTO;
import java.io.FileNotFoundException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ali Alzantot
 */
@WebServlet(name = "CartBuy", urlPatterns = {"/CartBuy"})
public class CartBuy extends HttpServlet {

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
            out.println("<title>Servlet CardBuy</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CardBuy at " + request.getContextPath() + "</h1>");
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
        
        response.sendRedirect("products.jsp");

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
                    HttpSession session =request.getSession(false);
                    ProductsDAOImp productsDAOImp=new ProductsDAOImp();
                    UsersDAOImp usersDAOImp=new UsersDAOImp();

                    ArrayList<UserProductsDTO> cartProducts=(ArrayList<UserProductsDTO>) session.getAttribute("cart");
                    UserProductsDAOImp up=new UserProductsDAOImp();
                    int count=0;
                    ProductsDTO product=null;
                    for (int i=0;i<cartProducts.size();++i){
                        try {
                            product=productsDAOImp.retreiveById(cartProducts.get(i).getProduct_id());
                        } catch (SQLException ex) {
                            Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        count+=(cartProducts.get(i).getQuantity()) * product.getPrice();
                    }
                    //if coount less or equal cart buy get cart from session
                    UsersDAOImp userDAOImp=new UsersDAOImp();
                    int credit=0;
                    try {
                        credit = userDAOImp.retreiveByID((Integer)session.getAttribute("id")).getCreditLimit();
                    } catch (SQLException ex) {
                        Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(count<= credit){
                        
                        int stockFlage=0;
                        String itemHasError=null;
                        for (int i=0;i<cartProducts.size();++i){
                            //get stock from database
                            ProductsDTO p = cartProducts.get(i).getProduct();
                            
                            try {
                                if(cartProducts.get(i).getQuantity()>productsDAOImp.retreiveById(p.getId()).getStock()){
                                    stockFlage=1;
                                    itemHasError=cartProducts.get(i).getProduct().getName();
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(stockFlage==1){
                            //RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                            request.setAttribute("error", new String("stockerror"));
                            request.setAttribute("item", new String(itemHasError));
                            //rd.forward(request, response); 
                            RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                            rd.forward(request, response);   
                        }
                        else{
                            for (int i=0;i<cartProducts.size();++i){
                                
                               cartProducts.get(i).setStatus(1);
                               cartProducts.get(i).getProduct().setStock(cartProducts.get(i).getProduct().getStock()-cartProducts.get(i).getQuantity());
                               cartProducts.get(i).getProduct().setStatus(0);
                               try {
                                    productsDAOImp.update( cartProducts.get(i).getProduct());
                                } catch (SQLException ex) {
                                    Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                                }
                               up.delete(cartProducts.get(i));
                               up.create(cartProducts.get(i));
                            }
                            try {
                                UsersDTO user=usersDAOImp.retreiveByMail((String)session.getAttribute("email"));
                                user.setCreditLimit(user.getCreditLimit()-count);
                                session.setAttribute("credit", user.getCreditLimit());
                                usersDAOImp.update(user);
                            } catch (SQLException ex) {
                                Logger.getLogger(CartBuy.class.getName()).log(Level.SEVERE, null, ex);
                            }


                            cartProducts.clear();
                           // RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                            request.setAttribute("error", new String("success"));
                           // rd.forward(request, response); 
                            RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                            rd.forward(request, response);   
                        }
                    }
                    
                    //else error msg
                    else{
                      //  RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                        request.setAttribute("error", new String("carterror"));
                     //   rd.forward(request, response);  
                        RequestDispatcher rd =request.getRequestDispatcher("cart.jsp");
                        rd.forward(request, response);  
                    }
                    
                    
                    
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

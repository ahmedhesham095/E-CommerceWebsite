/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import daoimp.ProductsDAOImp;
import daoimp.UserProductsDAOImp;
import dto.UserProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ali Alzantot
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

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
            out.println("<title>Servlet AddToCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart at " + request.getContextPath() + "</h1>");
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

        ProductsDAOImp productsDAOImp=new ProductsDAOImp();
                HttpSession session =request.getSession(false);
                if(session.getAttribute("name") == null){
                    //redirect to login page
                   // session=request.getSession(true);
//                    ArrayList<UserProductsDTO> cartProducts =new ArrayList<UserProductsDTO>();
//                    
//                    UserProductsDTO up=new UserProductsDTO();
//                    //getuseridfromsession
//                    up.setUser_id(2);
//                    up.setProduct_id(Integer.parseInt(request.getParameter("productId")));
//                    up.setQuantity(1);
//                    up.setStatus(0);
//                    ProductsDAOImp pd=new ProductsDAOImp();
//                    try {
//                        up.setProduct(pd.retreiveById(Integer.parseInt(request.getParameter("productId"))));
//                    } catch (SQLException ex) {
//                        Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    cartProducts.add(up);
                    session.setAttribute("error", new String("guest"));
//                    session.setAttribute("cart",cartProducts);
                    response.sendRedirect(request.getHeader("referer"));
//                    RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                    rd.forward(request, response);                    
                }
                else{

                    ArrayList<UserProductsDTO> cartProducts=(ArrayList<UserProductsDTO>) session.getAttribute("cart");
                    int flage=0;
                    int quantity=0,stock=1;
                    UserProductsDAOImp userPro = new UserProductsDAOImp();
                    ArrayList<UserProductsDTO> userProductList = new ArrayList<UserProductsDTO>();
                    userProductList = userPro.searchByStatus((Integer) session.getAttribute("id"), 0);
                    
                    if(cartProducts == null){
                    
                        cartProducts =new ArrayList<UserProductsDTO>();
                    int userId = (Integer) session.getAttribute("id");
                        UserProductsDTO up=new UserProductsDTO();
                    //getuseridfromsession
                    up.setUser_id(userId);
                    up.setProduct_id(Integer.parseInt(request.getParameter("productId")));
                    up.setQuantity(1);
                    up.setStatus(0);
                    ProductsDAOImp pd=new ProductsDAOImp();
                    try {
                        up.setProduct(pd.retreiveById(Integer.parseInt(request.getParameter("productId"))));
                    } catch (SQLException ex) {
                        Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cartProducts.add(up);
                    boolean check=false;
                    for (int j = 0; j < userProductList.size(); j++) {

                        if (up.getProduct().getId() == userProductList.get(j).getProduct_id()) {

                            userPro.update(up);
                            check = true;
                            break;
                        }

                    }
                    if (check == false) {

                        userPro.create(up);
                    }
                    session.setAttribute("error", new String("success"));
                    session.setAttribute("cart",cartProducts);
                    response.sendRedirect(request.getHeader("referer"));
//                    RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                    rd.forward(request, response);
                    }else{
                    for (int i=0;i<cartProducts.size();++i){
                        if(Integer.parseInt(request.getParameter("productId")) == cartProducts.get(i).getProduct_id() ){
                            quantity=cartProducts.get(i).getQuantity();
                            try {

                                stock=productsDAOImp.retreiveById(cartProducts.get(i).getProduct_id()).getStock();
                            } catch (SQLException ex) {
                                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if(stock<=quantity){
                      
                       session.setAttribute("error", new String("error"));
                       response.sendRedirect(request.getHeader("referer"));
//                        RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                        rd.forward(request, response);                       
                   }
                   else{
                        for (int i=0;i<cartProducts.size();++i){
                            if(cartProducts.get(i).getUser_id()== (Integer)session.getAttribute("id") && Integer.parseInt(request.getParameter("productId")) == cartProducts.get(i).getProduct_id() ){
                                cartProducts.get(i).setQuantity(cartProducts.get(i).getQuantity()+1);
                                flage=1;
                            }
                        }
                        if(flage==0){
                            UserProductsDTO up=new UserProductsDTO();
                            //getuseridfromsession
                            int userId = (Integer) session.getAttribute("id");
                            up.setUser_id(userId);
                            up.setProduct_id(Integer.parseInt(request.getParameter("productId")));
                            up.setQuantity(1);
                            up.setStatus(0);
                            ProductsDAOImp pd=new ProductsDAOImp();
                            try {
                                up.setProduct(pd.retreiveById(Integer.parseInt(request.getParameter("productId"))));
                            } catch (SQLException ex) {
                                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
                            }                    
                            cartProducts.add(up);
                            boolean check=false;
                    for (int j = 0; j < userProductList.size(); j++) {

                        if (up.getProduct().getId() == userProductList.get(j).getProduct_id()) {

                            userPro.update(up);
                            check = true;
                            break;
                        }

                    }
                    if (check == false) {

                        userPro.create(up);
                    }
                        }
                        session.setAttribute("cart",cartProducts);
                        session.setAttribute("error", new String("success"));
                        response.sendRedirect(request.getHeader("referer"));
//                        RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                        rd.forward(request, response);
                    }
                    }

                }
        
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
//                ProductsDAOImp productsDAOImp=new ProductsDAOImp();
//                HttpSession session =request.getSession(false);
//                if(session == null){
//                    //redirect to login page
//                    session=request.getSession(true);
//                    ArrayList<UserProductsDTO> cartProducts =new ArrayList<UserProductsDTO>();
//                    
//                    UserProductsDTO up=new UserProductsDTO();
//                    //getuseridfromsession
//                    up.setUser_id(2);
//                    up.setProduct_id(Integer.parseInt(request.getParameter("productId")));
//                    up.setQuantity(1);
//                    up.setStatus(0);
//                    ProductsDAOImp pd=new ProductsDAOImp();
//                    try {
//                        up.setProduct(pd.retreiveById(Integer.parseInt(request.getParameter("productId"))));
//                    } catch (SQLException ex) {
//                        Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    cartProducts.add(up);
//                    request.setAttribute("error", new String("success"));
//                    session.setAttribute("cart",cartProducts);
//                    //response.sendRedirect(request.getHeader("referer"));
//                    RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                    rd.forward(request, response);                    
//                }
//                else{
//
//                    ArrayList<UserProductsDTO> cartProducts=(ArrayList<UserProductsDTO>) session.getAttribute("cart");
//                    int flage=0;
//                    int quantity=0,stock=1;
//                    for (int i=0;i<cartProducts.size();++i){
//                        if(Integer.parseInt(request.getParameter("productId")) == cartProducts.get(i).getProduct_id() ){
//                            quantity=cartProducts.get(i).getQuantity();
//                            try {
//
//                                stock=productsDAOImp.retreiveById(cartProducts.get(i).getProduct_id()).getStock();
//                            } catch (SQLException ex) {
//                                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                    }
//                    if(stock<=quantity){
//                      
//                       request.setAttribute("error", new String("error"));
//                       //response.sendRedirect(request.getHeader("referer"));
//                        RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                        rd.forward(request, response);                       
//                   }
//                   else{
//                        for (int i=0;i<cartProducts.size();++i){
//                            if(cartProducts.get(i).getUser_id()==2&& Integer.parseInt(request.getParameter("productId")) == cardProducts.get(i).getProduct_id() ){
//                                cartProducts.get(i).setQuantity(cartProducts.get(i).getQuantity()+1);
//                                flage=1;
//                            }
//                        }
//                        if(flage==0){
//                            UserProductsDTO up=new UserProductsDTO();
//                            //getuseridfromsession
//                            up.setUser_id(2);
//                            up.setProduct_id(Integer.parseInt(request.getParameter("productId")));
//                            up.setQuantity(1);
//                            up.setStatus(0);
//                            ProductsDAOImp pd=new ProductsDAOImp();
//                            try {
//                                up.setProduct(pd.retreiveById(Integer.parseInt(request.getParameter("productId"))));
//                            } catch (SQLException ex) {
//                                Logger.getLogger(AddToCart.class.getName()).log(Level.SEVERE, null, ex);
//                            }                    
//                            cartProducts.add(up);
//                        }
//                        session.setAttribute("cart",cartProducts);
//                        request.setAttribute("error", new String("success"));
//                        //response.sendRedirect(request.getHeader("referer"));
//                        RequestDispatcher rd =request.getRequestDispatcher("products.jsp");
//                        rd.forward(request, response);
//                    }
//
//                }
		
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

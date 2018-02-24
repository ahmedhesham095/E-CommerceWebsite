/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package header;

import daoimp.UserProductsDAOImp;
import dto.UserProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shimaa
 */
public class SignOut extends HttpServlet {

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
            out.println("<title>Servlet SignOut</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignOut at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession(false);
        UserProductsDAOImp userPro = new UserProductsDAOImp();
        ArrayList<UserProductsDTO> userProductList = new ArrayList<UserProductsDTO>();
        ArrayList<UserProductsDTO> cartProducts = (ArrayList<UserProductsDTO>) session.getAttribute("cart");
        userProductList = userPro.searchByStatus((Integer) session.getAttribute("id"), 0);

        boolean check = false;
        if (cartProducts != null) {
            for (int i = 0; i < cartProducts.size(); i++) {
                check = false;
                for (int j = 0; j < userProductList.size(); j++) {

                    if (cartProducts.get(i).getProduct_id() == userProductList.get(j).getProduct_id()) {

                        userPro.update(cartProducts.get(i));
                        check = true;
                        break;
                    }

                }
                if (check == false) {

                    userPro.create(cartProducts.get(i));
                }

            }
        }

        session.setAttribute("cart", null);

        session.setAttribute("id", null);
        session.setAttribute("name", null);
        session.setAttribute("email", null);
        session.setAttribute("address", null);
        session.setAttribute("job", null);
        session.setAttribute("dob", null);
        session.setAttribute("credit", null);
        session.setAttribute("admin", null);
        response.sendRedirect("Home");

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

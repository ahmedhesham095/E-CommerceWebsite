/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

import daoimp.CategoriesDAOImp;
import daoimp.UserInterestDAOImp;
import dto.CategoriesDTO;
import dto.UserInterstsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
@WebServlet(name = "Intersts", urlPatterns = {"/Intersts"})
public class Intersts extends HttpServlet {

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
             UserInterestDAOImp myInt = new UserInterestDAOImp();
            
            ArrayList<UserInterstsDTO> interest = new ArrayList<>();
            ArrayList<CategoriesDTO> categories = new ArrayList<>();
            HttpSession session = request.getSession();
            CategoriesDAOImp imp = new CategoriesDAOImp();
           categories =  imp.readAll();
           interest = myInt.readAllByUserId((Integer)session.getAttribute("id")); 
           request.setAttribute("userint", interest);
            //System.out.println(interest.get(0).getCategory_id());
           request.setAttribute("interest", categories);
           Map<String, Integer> cat = new HashMap<String, Integer>();
          //  HashMap<Integer,String> cat = new HashSet<>();
          Map<String, Integer> checList = new HashMap<String, Integer>();
          // ArrayList<String> checList = new ArrayList<>();
           int added=0;
           for(CategoriesDTO cats : categories)
           {
               added=0;
               for (UserInterstsDTO ints : interest) {
               if(cats.getId() == (ints.getCategory_id()))
               {
                   //cat.add(cats.getName());
                   cat.put(cats.getName(), cats.getId());
                   added=1;
                   break;
               //    System.out.println("if" + cat);
               }
               }
               if(added ==0)
                   checList.put(cats.getName(), cats.getId());
                 //   checList.add(cats.getName());
           }
        //  for(String catssn : cat) 
         // {
           //   System.out.println("if"+ catssn);
          //}
      //    for (cat<String, String> entry : map.entrySet())
//{
  //  System.out.println(entry.getKey() + "/" + entry.getValue());
//}
  //         for(String catssns : checList) 
    //      {
      //        System.out.println("else "+ catssns);
        //  }
            
          //  RequestDispatcher rd = getServletContext().getRequestDispatcher("/editProfile.jsp");
          request.setAttribute("checked", cat);
          request.setAttribute("unchecked", checList);
          //  RequestDispatcher rd = getServletContext().getRequestDispatcher("/editProfile.jsp");
          RequestDispatcher rd = request.getRequestDispatcher("/editProfile.jsp");
        rd.forward(request, response);
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

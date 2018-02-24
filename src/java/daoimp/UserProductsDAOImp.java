/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import dbconnection.ConnectionFactory;
import dto.UserProductsDTO;
import java.sql.ResultSet;
import daoint.UserProductsDAOInt;
import dto.UsersDTO;

/**
 *
 * @author Freeware Sys
 */
public class UserProductsDAOImp implements UserProductsDAOInt {


    @Override
    public UserProductsDTO create(UserProductsDTO u1) {
        Connection connection = ConnectionFactory.getConnection();
        Calendar cal = Calendar.getInstance();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
        try {
            PreparedStatement pst = connection.prepareStatement("insert into ecommerce.users_products (user_id,product_id,buying_date,quantity,status) values (?,?,?,?,?)");
            pst.setInt(1, u1.getUser_id());
            pst.setInt(2, u1.getProduct_id());
            pst.setTimestamp(3, timestamp);
            pst.setInt(4, u1.getQuantity());
            pst.setInt(5, u1.getStatus());
            boolean i = pst.execute();
            if (i == false) {
                System.err.println("row is inserted !!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return u1;
    }

    @Override
    public UserProductsDTO update(UserProductsDTO u1) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("update ecommerce.users_products set users_products.quantity = ? , users_products.status=? where users_products.user_id =? and users_products.product_id = ? and users_products.status = ?");
            pst.setInt(1, u1.getQuantity());
            pst.setInt(2, u1.getStatus());
            pst.setInt(3, u1.getUser_id());
            pst.setInt(4, u1.getProduct_id());
            pst.setInt(5, 0);

            int i = pst.executeUpdate();
            if (i == 0) {
                System.err.println("row is updated !!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return u1;
    }

    @Override
    public Boolean delete(UserProductsDTO u1) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("delete from ecommerce.users_products where users_products.user_id =? and users_products.product_id = ? and users_products.status = ? ");
            pst.setInt(1, u1.getUser_id());
            pst.setInt(2, u1.getProduct_id());
            pst.setInt(3, 0);
            boolean i = pst.execute();
            if (i == false) {
                System.err.println("row deleted");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;

    }
    
     @Override
    public ArrayList<UserProductsDTO> searchByUserId(int userId) {
        ArrayList<UserProductsDTO> products = new ArrayList();
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("Select user_id , product_id , quantity , status  from ecommerce.users_products where ecommerce.users_products.user_id = ? ");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UserProductsDTO u = new UserProductsDTO();
                u.setUser_id(rs.getInt(1));
                u.setProduct_id(rs.getInt(2));
                u.setQuantity(rs.getInt(3));
                u.setStatus(rs.getInt(4));
                products.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterestDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

//    @Override
//    public ArrayList<UserProductsDTO> searchByUserId(UserProductsDTO u1) {
//        ArrayList<UserProductsDTO> products = new ArrayList();
//        Connection connection = ConnectionFactory.getConnection();
//        try {
//            PreparedStatement pst = connection.prepareStatement("Select user_id , product_id , quantity , status  from ecommerce.users_products where ecommerce.users_products.user_id = ? ");
//            pst.setInt(1, u1.getUser_id());
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                UserProductsDTO u = new UserProductsDTO();
//                u.setUser_id(rs.getInt(1));
//                u.setProduct_id(rs.getInt(2));
//                u.setQuantity(rs.getInt(3));
//                u.setStatus(rs.getInt(4));
//                products.add(u);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserInterestDAOImp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return products;
//    }
    
    @Override
    public ArrayList<UserProductsDTO> searchByStatus(int userId, int status) {
        ArrayList<UserProductsDTO> prod = new ArrayList();
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from ecommerce.users_products where users_products.user_id =? and users_products.status =? ");
            pst.setInt(1, userId);
            pst.setInt(2, status);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UserProductsDTO u = new UserProductsDTO();
                u.setUser_id(rs.getInt(1));
                u.setProduct_id(rs.getInt(2));
                u.setBuying_date(rs.getString(3));
                u.setQuantity(rs.getInt(4));
                u.setStatus(rs.getInt(5));
                prod.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return prod;
    }

    @Override
    public int countByStatus(UsersDTO user, int status) {
        Connection connection = ConnectionFactory.getConnection();
        int prod_countl=0;
        try {
            PreparedStatement pst = connection.prepareStatement("select  count(*) from ecommerce.users_products where users_products.user_id =? and users_products.status =? ");
            pst.setInt(1, user.getId());
            pst.setInt(2, status);
            ResultSet rs = pst.executeQuery();
            rs.next();
            prod_countl = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return prod_countl;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import dbconnection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.UserInterstsDTO;
import daoint.UserInterstsDAOInt;
import dto.CategoriesDTO;

/**
 *
 * @author Freeware Sys
 */
public class UserInterestDAOImp implements UserInterstsDAOInt {

    /* create user interest */
    @Override
    public UserInterstsDTO create(UserInterstsDTO u1) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("insert into ecommerce.users_interests (user_id,category_id) values (?,?)");
            pst.setInt(1, u1.getUser_id());
            pst.setInt(2, u1.getCategory_id());
            boolean i = pst.execute();
            if (i == false) {
                System.err.println("row is inserted !!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return u1;
    }

    /* retun all interests for user */
   @Override
    public ArrayList<UserInterstsDTO> readAllByUserId(int id) {
        Connection connection = ConnectionFactory.getConnection();
        
        ArrayList categories = new ArrayList();
        try {
            PreparedStatement pst = connection.prepareStatement("Select * from ecommerce.users_interests where ecommerce.users_interests.user_id = ? ");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UserInterstsDTO u1 = new UserInterstsDTO();
                u1.setUser_id(rs.getInt("user_id")); 
                u1.setCategory_id(rs.getInt("category_id"));
                categories.add(u1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserInterestDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    /* delete interest by user id **/
    @Override
    public Boolean delete(UserInterstsDTO u1) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("delete from ecommerce.users_interests where user_id=?");
            pst.setInt(1, u1.getUser_id());
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

}

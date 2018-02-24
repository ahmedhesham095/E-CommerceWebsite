/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import daoint.CategoriesDAOInt;
import dto.CategoriesDTO;
import dbconnection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Shimaa
 */
public class CategoriesDAOImp implements CategoriesDAOInt{
    
    @Override
    public ArrayList<CategoriesDTO> readAll() {
        ArrayList<CategoriesDTO> category = new ArrayList();
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from ecommerce.categories ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CategoriesDTO c1 = new CategoriesDTO();
                c1.setId(rs.getInt(1));
                c1.setName(rs.getString(2));
                category.add(c1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return category;
    }
    
    
    @Override
    public CategoriesDTO searchById(int categoryId) {
        CategoriesDTO category = new CategoriesDTO();
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from ecommerce.categories where id =" + categoryId );
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return category;
    }
    
}

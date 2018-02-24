/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import dto.UsersDTO;
import java.sql.Connection;
import dbconnection.ConnectionFactory;
import daoint.UsersDAOInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nouran
 */
public class UsersDAOImp implements UsersDAOInt {

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public UsersDTO create(UsersDTO user) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getAddress());
        ps.setString(6, user.getJob());
        //ps.setDate(7, user.getDateOfBirth());
        ps.setString(7, user.getDateOfBirth());
        ps.setInt(8, user.getCreditLimit());
        ps.setInt(9, user.getIsAdmin());

        ps.executeUpdate();
        return user;
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public UsersDTO update(UsersDTO user) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("update users "
                + "set name=?, email=?, password=?, address=?, job=?, "
                + "date_of_birth=?, credit_limit=?, isadmin=? where id=? ");

        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getAddress());
        ps.setString(5, user.getJob());
        //ps.setDate(6, user.getDateOfBirth());
        ps.setString(6, user.getDateOfBirth());
        ps.setInt(7, user.getCreditLimit());
        ps.setInt(8, user.getIsAdmin());
        ps.setInt(9, user.getId());

        ps.executeUpdate();
        return user;
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ArrayList<UsersDTO> retreive() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();
        ArrayList<UsersDTO> users = new ArrayList<>();
        while (rs.next()) {
            users.add(getUser(rs));
        }
        return users;
    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public UsersDTO retreiveByMailAndPass(String email, String password) throws SQLException {
        UsersDTO user = new UsersDTO();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from users where email=? and password=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = getUser(rs);
            return user;
        } else {
            return null;
        }
    }

    
    @Override
    public UsersDTO retreiveByMail(String email) throws SQLException {
        UsersDTO user = new UsersDTO();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from users where email=?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = getUser(rs);
            return user;
        } else {
            return null;
        }
    }
    
    
    @Override
    public UsersDTO retreiveByID(int id) throws SQLException {
        UsersDTO user = new UsersDTO();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from users where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
       if(rs.next()) {
           user = getUser(rs);
            return user;
        }
       else {
           return null;
       }
    }
    
    
    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public UsersDTO getUser(ResultSet rs) throws SQLException {

        UsersDTO user = new UsersDTO();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setJob(rs.getString("job"));
        user.setDateOfBirth(rs.getString("date_of_birth"));
        user.setCreditLimit(rs.getInt("credit_limit"));
        user.setIsAdmin(rs.getInt("isadmin"));

        return user;
    }

}

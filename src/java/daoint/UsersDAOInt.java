/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoint;

import dto.UsersDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nouran
 */
public interface UsersDAOInt {

    UsersDTO create(UsersDTO user) throws SQLException;

    UsersDTO update(UsersDTO user) throws SQLException;

    ArrayList<UsersDTO> retreive() throws SQLException;

    UsersDTO retreiveByMailAndPass(String email, String password) throws SQLException;
    UsersDTO retreiveByMail(String email) throws SQLException;
    
    UsersDTO retreiveByID(int id) throws SQLException;
}

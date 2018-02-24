/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoint;

import java.util.ArrayList;
import dto.UserProductsDTO;
import dto.UsersDTO;

/**
 *
 * @author Freeware Sys
 */
public interface UserProductsDAOInt {
    UserProductsDTO create(UserProductsDTO u1);
    UserProductsDTO update(UserProductsDTO u1);
    Boolean delete(UserProductsDTO u1);
    //ArrayList<UserProductsDTO> searchByUserId(UserProductsDTO u1);
    int countByStatus(UsersDTO user, int status);
    ArrayList<UserProductsDTO> searchByStatus(int userId, int status);
    ArrayList<UserProductsDTO> searchByUserId(int userId);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoint;

import java.util.ArrayList;
import dto.UserInterstsDTO;

/**
 *
 * @author Freeware Sys
 */
public interface UserInterstsDAOInt {
    UserInterstsDTO create(UserInterstsDTO u1);
    ArrayList readAllByUserId(int userId);
    Boolean delete(UserInterstsDTO u1);
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoint;

import dto.CategoriesDTO;
import java.util.ArrayList;

/**
 *
 * @author Shimaa
 */
public interface CategoriesDAOInt {
    
    ArrayList<CategoriesDTO> readAll();
    CategoriesDTO searchById(int categoryId);
    
}

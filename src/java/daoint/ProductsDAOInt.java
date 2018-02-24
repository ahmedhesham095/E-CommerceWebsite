/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoint;

import dto.ProductsDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nouran
 */
public interface ProductsDAOInt {

    void create(ProductsDTO product) throws SQLException, IOException;

    ArrayList<ProductsDTO> retreive() throws SQLException;

    ProductsDTO update(ProductsDTO product) throws SQLException, FileNotFoundException, IOException;

    ArrayList<ProductsDTO> searchByCategory(int category) throws SQLException;

    ArrayList<ProductsDTO> searchByName(String name) throws SQLException;

    ArrayList<ProductsDTO> searchByPrice(int price) throws SQLException;

    void delete(ProductsDTO product) throws SQLException;
    
    //byte[] getImg(int productId) throws SQLException;
    InputStream getImg(int productId) throws SQLException;
    
    ProductsDTO retreiveById(int id)throws SQLException;
    
    String getName(int id);
}

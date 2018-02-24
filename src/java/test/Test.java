/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.CategoriesDTO;
import daoimp.CategoriesDAOImp;
import daoimp.ProductsDAOImp;
import daoimp.UserProductsDAOImp;
import daoimp.UsersDAOImp;
import dto.ProductsDTO;
import dto.UserProductsDTO;
import dto.UsersDTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nouran
 */
public class Test {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        ProductsDAOImp product = new ProductsDAOImp();
        ProductsDTO productX = new ProductsDTO();
        UsersDAOImp user = new UsersDAOImp();
        UsersDTO userX = new UsersDTO();
        UsersDTO userS = new UsersDTO();
        
        CategoriesDAOImp cat = new CategoriesDAOImp();

        ArrayList<CategoriesDTO> categories = new ArrayList<CategoriesDTO>();
        categories = cat.readAll();
        
        for(int i=0; i< categories.size(); i++){
            
            System.out.println(categories.get(i).getId() + categories.get(i).getName());
        }

        productX.setId(9);
        productX.setName("product9");
        productX.setPrice(600);
        productX.setStock(5);
        productX.setCategoryId(2);
        
        product.update(productX);
        product.delete(productX);
        
        userX.setId(5);
        userX.setName("Nouran");
        userX.setAddress("Alexandria");
        userX.setCreditLimit(10000);
        userX.setEmail("nouran@gmail.com");
        userX.setPassword("1234");
        
        user.update(userX);
        userS=user.retreiveByMailAndPass("shimaa@gmail.com", "12345678");
        
        UserProductsDAOImp userProduct = new UserProductsDAOImp();

        ArrayList<UserProductsDTO> userPro = new ArrayList<UserProductsDTO>();
        //userPro = userProduct.searchByStatus(user.retreiveByMailAndPass("shimaa@yahoo.com", "123456"), 0);
        
        for(int i=0; i< userPro.size(); i++){
            
            System.out.println(userPro.get(i).getUser_id()+ " " + userPro.get(i).getProduct_id() + " " + userPro.get(i).getStatus());
        }
        
        System.out.println("Count: " + userProduct.countByStatus(user.retreiveByMailAndPass("shimaa@yahoo.com", "123456"), 0));
        
        System.out.println(userS.getEmail() + " " + userS.getName());
        System.out.println(productX.getImg());
        System.out.println(user.retreive());
        System.out.println(product.searchByCategory(1));
        System.out.println(product.searchByName("product1"));
        System.out.println(product.searchByPrice(250));
    }
    
}

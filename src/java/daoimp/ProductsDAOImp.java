/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import dbconnection.ConnectionFactory;
import dto.ProductsDTO;
import daoint.ProductsDAOInt;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nouran
 */
public class ProductsDAOImp implements ProductsDAOInt {

    /**
     *
     * @param product
     * @throws SQLException
     * @throws IOException
     */
    @Override
    public void create(ProductsDTO product) throws SQLException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        //File image = new File("src/java/imgs/img.jpg");
//        Path path = Paths.get(image.getAbsolutePath());
//        byte[] data = Files.readAllBytes(path);
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        PreparedStatement ps = connection.prepareStatement("insert into products values (?,?,?,?,?,?,?)");
        ps.setInt(1, product.getId());
        ps.setString(2, product.getName());
        ps.setInt(3, product.getPrice());
        ps.setInt(4, product.getStock());

        if (product.getImg() == null) {
            ps.setBlob(5, product.getImg());
        } else {
            ps.setBinaryStream(5, (InputStream) product.getImg());
        }
        ps.setInt(6, product.getCategoryId());
        ps.setInt(7, product.getStatus());
        ps.executeUpdate();
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ArrayList<ProductsDTO> retreive() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products where status=?");
        ps.setInt(1, 0);
        ResultSet rs = ps.executeQuery();
        ArrayList<ProductsDTO> products = new ArrayList<>();
        while (rs.next()) {
            products.add(getProduct(rs));
        }
        
        
        return products;
    }

    /**
     *
     * @param product
     * @return
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public ProductsDTO update(ProductsDTO product) throws SQLException, FileNotFoundException, IOException {
        Connection connection = ConnectionFactory.getConnection();
//        File image = new File("src/java/imgs/img.jpg");
//        Path path = Paths.get(image.getAbsolutePath());
//        byte[] data = Files.readAllBytes(path);
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        PreparedStatement ps = connection.prepareStatement("update products "
                + "set name=?, price=?, stock=?, img=?, category_id=?, status=?  where id=? ");
        ps.setString(1, product.getName());
        ps.setInt(2, product.getPrice());
        ps.setInt(3, product.getStock());
        
        if (product.getImg() == null) {
            ps.setBlob(4, product.getImg());
        } else {
//            ps.setBinaryStream(4, new ByteArrayInputStream(product.getImg()), product.getImg().length);
                 ps.setBinaryStream(4,  (InputStream) product.getImg());
        }

        ps.setInt(5, product.getCategoryId());
        ps.setInt(6, product.getStatus());
        ps.setInt(7, product.getId());
        ps.executeUpdate();
        return product;
    }

    /**
     *
     * @param category
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ProductsDTO> searchByCategory(int category) throws SQLException {
        ArrayList<ProductsDTO> products = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products where category_id=? and status=?");
        ps.setInt(1, category);
        ps.setInt(2, 0);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            products.add(getProduct(rs));
        }
        return products;
    }

    /**
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ProductsDTO> searchByName(String name) throws SQLException {
        ArrayList<ProductsDTO> products = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products where name=? and status=?");
        ps.setString(1, name);
        ps.setInt(2, 0);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            products.add(getProduct(rs));
        }
        return products;
    }

    /**
     *
     * @param price
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ProductsDTO> searchByPrice(int price) throws SQLException {
        ArrayList<ProductsDTO> products = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products where price=? and status=?");
        ps.setInt(1, price);
        ps.setInt(2, 0);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            products.add(getProduct(rs));
        }
        return products;
    }
    
    
    @Override
    public InputStream getImg(int productId) throws SQLException {
        InputStream image = null;
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select img from products where id=? ");
        ps.setInt(1, productId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Blob imgBlob = rs.getBlob("img");
        if (!rs.wasNull()) {
            image = imgBlob.getBinaryStream();
            
        }
        }
        return image;
    }

    /**
     *
     * @param product
     * @throws SQLException
     */
    @Override
    public void delete(ProductsDTO product) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from products where id=?");
        {
            ps.setInt(1, product.getId());
            ps.executeUpdate();

        }

    }
    
    
    @Override
    public ProductsDTO retreiveById(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products where id = "+id);
       
        ResultSet rs = ps.executeQuery();
        ProductsDTO products = null;
        while (rs.next()) {
            products=getProduct(rs);
        }
        
        
        return products;
    }

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public ProductsDTO getProduct(ResultSet rs) throws SQLException {
        ProductsDTO product = new ProductsDTO();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));

        Blob imgBlob = rs.getBlob("img");
        if (!rs.wasNull()) {
            InputStream img = imgBlob.getBinaryStream();
//            byte[] img = imgBlob.getBytes(1, (int)imgBlob.length());
            product.setImg(img);
        } else {
            product.setImg(null);
        }

        product.setCategoryId(rs.getInt("category_id"));
        return product;
    }
    
    
    @Override
    public String getName(int id) {
        String productName = null;
        try {

            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps;

            ps = connection.prepareStatement("select name from products where id=?");
            ps.setInt(1, id);
            

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                productName = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productName;
    }

}

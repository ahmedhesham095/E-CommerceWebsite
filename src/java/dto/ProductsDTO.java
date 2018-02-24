/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.InputStream;
import java.io.Serializable;



/**
 *
 * @author Nouran
 */
public class ProductsDTO implements Serializable{

    private int id;
    private String name;
    private int price;
    private int stock;
    private InputStream img;
    private int categoryId;
    private int status;
    
    public ProductsDTO() {
        
    }

    public ProductsDTO(int id, String name, int price, int stock, InputStream img, int categoryId) {
        this.id = id; 
        this.name=new String(name); 
        this.price=price;
        this.stock=stock;
        this.img=img;
        this.categoryId=categoryId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

}

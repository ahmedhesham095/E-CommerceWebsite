/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
/**
 *
 * @author Freeware Sys
 */
public class UserProductsDTO implements Serializable{
    private int user_id;
    private int product_id;
    private String buying_date;
    private int quantity;
    private int status;
    private ProductsDTO product;
    public void setProduct(ProductsDTO product) {
        this.product = product;
    }

    public int getUser_id() {
        return user_id;
    }

    public ProductsDTO getProduct() {
        return product;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getBuying_date() {
        return buying_date;
    }

    public void setBuying_date(String buying_date) {
        this.buying_date = buying_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}

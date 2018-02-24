/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

import java.io.Serializable;
/**
 *
 * @author Nouran
 */
public class UsersDTO implements Serializable{

    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String job;
    //private Date dateOfBirth;
    private String dateOfBirth;
    private int creditLimit;
    private int isAdmin;

    public UsersDTO() {

    }

    public UsersDTO(int id, String name, String email, String password,
            String address, String job, String dateOfBirth, int creditLimit, int isAdmin) {
        this.id = id;
        this.name = new String(name);
        this.email = new String(email);
        this.password = new String(password);
        this.address = new String(address);
        this.job = new String(job);
        this.dateOfBirth = dateOfBirth;
        this.creditLimit = creditLimit;
        this.isAdmin = isAdmin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}

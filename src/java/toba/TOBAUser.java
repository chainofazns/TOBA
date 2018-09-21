/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Leo
 */
@Entity
public class TOBAUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String states;
    private String zipcode;
    private String email;
    private String username;
    private String password;
    
    
    public TOBAUser(){
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        states = "";
        zipcode = "";
        email = "";
        username = "";
        password = "";
    }
    
    public TOBAUser(String firstName, String lastName, String phone, 
            String address, String city, String state, String zipcode, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.states = state;
        this.zipcode = zipcode;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public int getUserId(){
        return userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    
    public String getState(){
        return states;
    }
    public void setState(String state){
        this.states = state;
    }
    
    public String getZipcode(){
        return zipcode;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String Password){
        this.password = Password;
    } 
}

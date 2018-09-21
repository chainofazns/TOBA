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
public class Transaction implements Serializable{
    @ Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactionId;
    private int userId;
    private double balance;
    private double delta;
    
    public Transaction(){
        userId = 0;
        balance = 0;
        delta = 0;
    }
    
    public Transaction(int userId, double balance, double delta){
        this.userId = userId;
        this.balance = balance;
        this.delta = delta;
    }
    
    public int getTransactionId(){
        return transactionId;
    }
   
            
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public double getDelta(){
        return delta;
    }
    
    public void setDelta(double delta){
        this.delta = delta;
    }
    
    public int getUserId(){            
         return userId;
    }
    
           
    
}

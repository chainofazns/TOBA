/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Leo
 */
@Entity
public class Account implements Serializable{
    @Id
    private int userId;
    private double balance;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Transaction> transactions;
        
    public Account(){
        userId = 0;
        balance = 25;       
    }
    
    public Account(int userId, double balance){
        this.userId = userId;
        this.balance = balance;
    }
    public List getTransactions(){
        return transactions;
    }
    public void addTransactions(Transaction transaction){
        transactions.add(transaction);
    }
    
    public int getUserId(){            
         return userId;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
                        
    public void credit(double add){
        balance = balance + add;
    }
    
    public void debit(double sub){
        balance = balance - sub;
    }

}

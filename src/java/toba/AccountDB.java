/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 *
 * @author Leo
 */
public class AccountDB {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TOBAPU");
    
    public static void insert(Account account){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(Account account){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static double getBalance(int userId){
        EntityManager em = emf.createEntityManager();
        String qString = "SELECT u From Account u " +
                "WHERE u.userId = :userId";
        TypedQuery<Account> q =  em.createQuery(qString, Account.class);
        q.setParameter("userId", userId);
        
        try{
            Account account = q.getSingleResult();
            return account.getBalance();
        } catch (NoResultException e) {
            return 0;
        } finally {
            em.close();
        }
    }
    
    public static Account getAccount(int userId){
        EntityManager em = emf.createEntityManager();
        String qString = "SELECT u From Account u " +
                "WHERE u.userId = :userId";
        TypedQuery<Account> q =  em.createQuery(qString, Account.class);
        q.setParameter("userId", userId);
        
        try{
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}

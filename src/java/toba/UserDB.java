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
public class UserDB {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("TOBAPU");
    
    public static void insert(TOBAUser user){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(TOBAUser user){
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static TOBAUser getUser(String username){
        EntityManager em = emf.createEntityManager();
        String qString = "SELECT u From User u " +
                "WHERE u.username = :username";
        TypedQuery<TOBAUser> q =  em.createQuery(qString, TOBAUser.class);
        q.setParameter("username", username);
        
        try{
            TOBAUser user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
}

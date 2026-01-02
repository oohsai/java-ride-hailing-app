package com.rideapp.dao;

import com.rideapp.model.User;
import javax.persistence.*;

public class UserDAO {
    public void saveUser(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public User login(String email, String password) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :e AND u.password = :p", User.class)
                     .setParameter("e", email)
                     .setParameter("p", password)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
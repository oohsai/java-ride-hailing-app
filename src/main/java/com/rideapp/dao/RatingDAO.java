package com.rideapp.dao;

import com.rideapp.model.Rating;
import javax.persistence.EntityManager;

public class RatingDAO {
    public void addRating(Rating rating) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rating);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
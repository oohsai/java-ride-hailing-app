package com.rideapp.dao;

import com.rideapp.model.Payment;
import com.rideapp.model.Ride;
import javax.persistence.EntityManager;

public class PaymentDAO {
    
    public void processPayment(Payment payment) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            
            // 1. Save Payment Record
            em.persist(payment);
            
            // 2. Update Ride status to 'paid'
            Ride ride = em.find(Ride.class, payment.getRide_id());
            if (ride != null) {
                ride.setStatus("paid");
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
package com.rideapp.dao;

import com.rideapp.model.Ride;
import javax.persistence.*;
import java.util.List;

public class RideDAO {
    
    public void createRide(Ride ride) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ride);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Ride> getAvailableRides() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Ride r WHERE r.status = 'requested'", Ride.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public Ride getRide(int rideId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Ride.class, rideId);
        } finally {
            em.close();
        }
    }

    // Generic status update
    public void updateRideStatus(int rideId, int driverId, String status) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Ride ride = em.find(Ride.class, rideId);
            if (ride != null) {
                if(driverId > 0) ride.setDriver_id(driverId);
                ride.setStatus(status);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Update status AND fare (For completion)
    public void updateRideStatusAndFare(int rideId, String status, double fare) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Ride ride = em.find(Ride.class, rideId);
            if (ride != null) {
                ride.setStatus(status);
                ride.setFare(fare);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
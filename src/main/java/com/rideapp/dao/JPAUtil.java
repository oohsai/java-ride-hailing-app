package com.rideapp.dao;
import javax.persistence.*;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("RidePU");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
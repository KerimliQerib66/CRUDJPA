package DAO.impl;


import DAO.inter.Customerİnter;
import DAO.inter.JPAUtil;
import entity.Customers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class CustomerImpl extends JPAUtil implements Customerİnter {
    @Override
    public void Insert(Customers c) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(c);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Customers> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT c FROM Customers c");
        ArrayList<Customers> entityList = (ArrayList<Customers>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Customers findbyid(int customerid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Customers customers = em.find(Customers.class, customerid);
        JPAUtil.shutdown();
        return customers;
    }



    @Override
    public Customers Update(int customerid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Customers customers=em.find(Customers.class,customerid);
        em.merge(customers);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return customers;
    }

    @Override
    public void remove(int customerid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Customers customers=em.find(Customers.class,customerid);
        em.remove(customers);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
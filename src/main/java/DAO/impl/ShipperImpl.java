package DAO.impl;

import DAO.inter.JPAUtil;
import DAO.inter.Shipperİnter;
import entity.Shippers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ShipperImpl extends JPAUtil implements Shipperİnter {
    @Override
    public void Insert(Shippers s) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(s);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Shippers> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT s FROM Shippers s");
        ArrayList<Shippers> entityList = (ArrayList<Shippers>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Shippers findbyid(int shipperid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Shippers s = em.find(Shippers.class, shipperid);
        JPAUtil.shutdown();
        return s;
    }

    @Override
    public Shippers Update(int shipperid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Shippers s=em.find(Shippers.class,shipperid);
        em.merge(s);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return s;
    }

    @Override
    public void remove(int shipperid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Shippers s=em.find(Shippers.class,shipperid);
        em.remove(s);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
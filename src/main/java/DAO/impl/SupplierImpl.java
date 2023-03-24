package DAO.impl;

import DAO.inter.JPAUtil;
import DAO.inter.Supplierİnter;
import entity.Suppliers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class SupplierImpl extends JPAUtil implements Supplierİnter {
    @Override
    public void Insert(Suppliers s) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(s);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Suppliers> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT s FROM Suppliers s");
        ArrayList<Suppliers> entityList = (ArrayList<Suppliers>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Suppliers findbyid(int supplierid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Suppliers s = em.find(Suppliers.class, supplierid);
        JPAUtil.shutdown();
        return s;
    }

    @Override
    public Suppliers Update(int supplierid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Suppliers s=em.find(Suppliers.class,supplierid);
        em.merge(s);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return s;
    }

    @Override
    public void remove(int supplierid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Suppliers s=em.find(Suppliers.class,supplierid);
        em.remove(s);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
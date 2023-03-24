package DAO.impl;

import DAO.inter.JPAUtil;
import DAO.inter.Productİnter;
import entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ProductImpl extends JPAUtil implements Productİnter {
    @Override
    public void Insert(Products p) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(p);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Products> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT p FROM Products p");
        ArrayList<Products> entityList = (ArrayList<Products>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Products findbyid(int productid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Products p = em.find(Products.class, productid);
        JPAUtil.shutdown();
        return p;
    }

    @Override
    public Products Update(int productid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Products p=em.find(Products.class,productid);
        em.merge(p);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return p;
    }

    @Override
    public void remove(int productid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Products p=em.find(Products.class,productid);
        em.remove(p);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
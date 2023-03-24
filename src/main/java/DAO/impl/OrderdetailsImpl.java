package DAO.impl;

import DAO.inter.JPAUtil;
import DAO.inter.Orderdetailİnter;
import entity.Orderdetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class OrderdetailsImpl extends JPAUtil implements Orderdetailİnter {
    @Override
    public void Insert(Orderdetails od) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(od);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Orderdetails> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT od FROM Orderdetails od");
        ArrayList<Orderdetails> entityList = (ArrayList<Orderdetails>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Orderdetails findbyid(int orderdetailid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Orderdetails od = em.find(Orderdetails.class, orderdetailid);
        JPAUtil.shutdown();
        return od;
    }

    @Override
    public Orderdetails Update(int orderdetailid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Orderdetails od=em.find(Orderdetails.class,orderdetailid);
        em.merge(od);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return od;
    }

    @Override
    public void remove(int orderdetailid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Orderdetails od=em.find(Orderdetails.class,orderdetailid);
        em.remove(od);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
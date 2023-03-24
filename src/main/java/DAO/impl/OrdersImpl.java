package DAO.impl;

import DAO.inter.JPAUtil;
import DAO.inter.Orderİnter;
import entity.Orders;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class OrdersImpl extends JPAUtil implements Orderİnter {
    @Override
    public void Insert(Orders o) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(o);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Orders> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT o FROM Orders o");
        ArrayList<Orders> entityList = (ArrayList<Orders>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Orders findbyid(int orderid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Orders o = em.find(Orders.class, orderid);
        JPAUtil.shutdown();
        return o;
    }

    @Override
    public Orders Update(int orderid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Orders o=em.find(Orders.class,orderid);
        em.merge(o);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return o;
    }

    @Override
    public void remove(int orderid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Orders o=em.find(Orders.class,orderid);
        em.remove(o);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
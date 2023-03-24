package DAO.impl;

import DAO.inter.Categoryİnter;
import DAO.inter.JPAUtil;
import entity.Categories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;


import java.util.ArrayList;

public class CategoryImpl extends JPAUtil implements Categoryİnter  {
    @Override
    public void Insert(Categories c) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(c);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Categories> SelectAll() {
      EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
      EntityTransaction entityTransaction=em.getTransaction();
      entityTransaction.begin();
        Query query = em.createQuery("SELECT c FROM Categories c");
        ArrayList<Categories> entityList = (ArrayList<Categories>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Categories findbyid(int categoryid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Categories categories = em.find(Categories.class, categoryid);
        JPAUtil.shutdown();
        return categories;

    }

    @Override
    public Categories Update(int categoryid) {
      EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
      EntityTransaction entityTransaction=em.getTransaction();
      entityTransaction.begin();
      Categories categories=em.find(Categories.class,categoryid);
      em.merge(categories);
      entityTransaction.commit();
      JPAUtil.shutdown();
      return  categories;
    }

    @Override
    public void remove(int categoryid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Categories categories=em.find(Categories.class,categoryid);
        em.remove(categories);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}

package DAO.impl;

import DAO.inter.Employeeİnter;
import DAO.inter.JPAUtil;
import entity.Employees;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class EmployeeImpl extends JPAUtil implements Employeeİnter {
    @Override
    public void Insert(Employees e) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        em.persist(e);
        em.getTransaction().commit();
        JPAUtil.shutdown();
    }

    @Override
    public ArrayList<Employees> SelectAll() {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Query query = em.createQuery("SELECT e FROM Employees e");
        ArrayList<Employees> entityList = (ArrayList<Employees>) query.getResultList();
        em.getTransaction().commit();
        JPAUtil.shutdown();
        return entityList;
    }

    @Override
    public Employees findbyid(int employeeid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        Employees employee = em.find(Employees.class, employeeid);
        JPAUtil.shutdown();
        return employee;
    }

    @Override
    public Employees Update(int employeeid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Employees employee=em.find(Employees.class,employeeid);
        em.merge(employee);
        entityTransaction.commit();
        JPAUtil.shutdown();
        return employee;
    }

    @Override
    public void remove(int employeeid) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction=em.getTransaction();
        entityTransaction.begin();
        Employees employee=em.find(Employees.class,employeeid);
        em.remove(employee);
        entityTransaction.commit();
        JPAUtil.shutdown();
    }
}
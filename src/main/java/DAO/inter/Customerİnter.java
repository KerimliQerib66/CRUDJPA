package DAO.inter;

import entity.Customers;
import entity.Employees;

import java.util.ArrayList;

public interface Customerİnter {
    public void Insert(Customers c);
    public ArrayList<Customers> SelectAll();
    public Customers  findbyid(int customerid);
    public Customers Update(int customerid);
    public void remove(int customerid);
}

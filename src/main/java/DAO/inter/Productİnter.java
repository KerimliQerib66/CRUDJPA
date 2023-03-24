package DAO.inter;

import entity.Orders;
import entity.Products;

import java.util.ArrayList;

public interface Productİnter {
    public void Insert(Products p);
    public ArrayList<Products> SelectAll();
    public Products findbyid(int productid);
    public Products Update(int productid);
    public void remove(int productid);
}

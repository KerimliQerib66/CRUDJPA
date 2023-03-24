package DAO.inter;

import entity.Categories;
import entity.Suppliers;

import java.util.ArrayList;

public interface Supplierİnter {
    public void Insert(Suppliers s);
    public ArrayList<Suppliers> SelectAll();
    public Suppliers findbyid(int supplierid);
    public Suppliers Update(int supplierid);
    public void remove(int supplierid);
}

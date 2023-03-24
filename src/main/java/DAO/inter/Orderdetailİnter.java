package DAO.inter;

import entity.Orderdetails;
import entity.Shippers;

import java.util.ArrayList;

public interface Orderdetailİnter {
    public void Insert(Orderdetails od);
    public ArrayList<Orderdetails> SelectAll();
    public Orderdetails findbyid(int orderdetailsid);
    public Orderdetails Update(int orderdetailid);
    public void remove(int orderdetailid);
}

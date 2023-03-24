package DAO.inter;

import entity.Orders;
import entity.Suppliers;

import java.util.ArrayList;

public interface Orderİnter {
    public void Insert(Orders o);
    public ArrayList<Orders> SelectAll();
    public Orders findbyid(int orderid);
    public Orders Update(int orderid);
    public void remove(int orderid);
}

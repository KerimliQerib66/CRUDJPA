package DAO.inter;

import entity.Shippers;

import java.util.ArrayList;

public interface Shipperİnter {
    public void Insert(Shippers s);
    public ArrayList<Shippers> SelectAll();
    public Shippers findbyid(int orderid);
    public Shippers Update(int shipperid);
    public void remove(int shipperid);
}

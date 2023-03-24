package DAO.inter;

import entity.Categories;

import java.util.ArrayList;

public interface Categoryİnter  {
    public void Insert(Categories c);
    public ArrayList<Categories> SelectAll();
    public Categories findbyid(int categoryid);
    public Categories Update(int categoryid);
    public void remove(int categoryid);
}

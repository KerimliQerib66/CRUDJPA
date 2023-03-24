package DAO.inter;

import entity.Employees;
import entity.Orderdetails;

import java.util.ArrayList;

public interface Employeeİnter {
    public void Insert(Employees e);
    public ArrayList<Employees> SelectAll();
    public Employees findbyid(int Employeeid);
    public Employees Update(int Employeeid);
    public void remove(int Employeeid);
}

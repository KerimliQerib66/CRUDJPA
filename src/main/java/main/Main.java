package main;

import DAO.impl.OrdersImpl;
import DAO.impl.ProductImpl;
import DAO.impl.ShipperImpl;
import DAO.inter.Orderİnter;
import DAO.inter.Productİnter;
import DAO.inter.Shipperİnter;
import entity.Orders;
import entity.Products;
import entity.Shippers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Productİnter p = new ProductImpl();
        Orderİnter o=new OrdersImpl();
        Shipperİnter s=new ShipperImpl();
//        for (Orders orders:o.SelectAll()) {
//            System.out.println(orders.toString());
//        }
//        for (Products product : p.SelectAll()) {
//            System.out.println(product.toString());
//        }
//        for (Shippers shippers:s.SelectAll()) {
//            System.out.println(shippers.toString());
//        }
    }
}

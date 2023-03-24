package entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID")
    private int orderId;
    @Basic
    @Column(name = "OrderDate")
    private Timestamp orderDate;
    @Basic
    @Column(name = "ShipperID")
    private Integer shipperId;
    @OneToMany(mappedBy = "orderId",fetch = FetchType.EAGER)
    private Collection<Orderdetails> orderdetailsByOrderId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customers customersByCustomerId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employees employeesByEmployeeId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }





    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (shipperId != null ? !shipperId.equals(orders.shipperId) : orders.shipperId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;


        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shipperId != null ? shipperId.hashCode() : 0);
        return result;
    }

    public Collection<Orderdetails> getOrderdetailsByOrderId() {
        return orderdetailsByOrderId;
    }

    public void setOrderdetailsByOrderId(Collection<Orderdetails> orderdetailsByOrderId) {
        this.orderdetailsByOrderId = orderdetailsByOrderId;
    }

    public Customers getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customers customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    public Employees getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Employees employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", shipperId=" + shipperId +
                ", orderdetailsByOrderId=" + orderdetailsByOrderId +
                ", customersByCustomerId=" + customersByCustomerId +
                ", employeesByEmployeeId=" + employeesByEmployeeId +
                '}';
    }
}

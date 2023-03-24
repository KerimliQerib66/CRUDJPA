package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Shippers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ShipperID")
    private int shipperId;
    @Basic
    @Column(name = "ShipperName")
    private String shipperName;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "shipperId",fetch = FetchType.EAGER)
    private Collection<Orders> ordersByShipperId;

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shippers shippers = (Shippers) o;

        if (shipperId != shippers.shipperId) return false;
        if (shipperName != null ? !shipperName.equals(shippers.shipperName) : shippers.shipperName != null)
            return false;
        if (phone != null ? !phone.equals(shippers.phone) : shippers.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shipperId;
        result = 31 * result + (shipperName != null ? shipperName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<Orders> getOrdersByShipperId() {
        return ordersByShipperId;
    }

    public void setOrdersByShipperId(Collection<Orders> ordersByShipperId) {
        this.ordersByShipperId = ordersByShipperId;
    }

    @Override
    public String toString() {
        return "Shippers{" +
                "shipperId=" + shipperId +
                ", shipperName='" + shipperName + '\'' +
                ", phone='" + phone + '\'' +
                ", ordersByShipperId=" + ordersByShipperId +
                '}';
    }
}

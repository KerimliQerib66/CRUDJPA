package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID")
    private int productId;
    @Basic
    @Column(name = "ProductName")
    private String productName;
    @Basic
    @Column(name = "SupplierID")
    private Integer supplierId;
    @Basic
    @Column(name = "Unit")
    private String unit;
    @Basic
    @Column(name = "Price")
    private Integer price;
    @OneToMany(mappedBy = "productId",fetch = FetchType.EAGER)
    private Collection<Orderdetails> orderdetailsByProductId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Categories categoriesByCategoryId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }



    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (productId != products.productId) return false;
        if (productName != null ? !productName.equals(products.productName) : products.productName != null)
            return false;
        if (supplierId != null ? !supplierId.equals(products.supplierId) : products.supplierId != null) return false;

        if (unit != null ? !unit.equals(products.unit) : products.unit != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);

        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Collection<Orderdetails> getOrderdetailsByProductId() {
        return orderdetailsByProductId;
    }

    public void setOrderdetailsByProductId(Collection<Orderdetails> orderdetailsByProductId) {
        this.orderdetailsByProductId = orderdetailsByProductId;
    }

    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @Override
    public String toString() {
        return "Products{" +
                ", productName='" + productName + '\'' +
                ", supplierId=" + supplierId +
                ", unit='" + unit + '\'' +
                ", price=" + price ;

    }
}

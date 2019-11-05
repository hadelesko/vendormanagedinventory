package org.launchcode.vendormangedinventory.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Warehouse_Customer {
    /* To catch the flow of material between warehouse and customer
    We won't necessary create a controller for this class. This is destinated
    to record the flows of sending product to the customer or the
    Retour of product from customer to the warehouse
    */

    @Id
    @GeneratedValue
    private int id;
    private int warehouseId;
    private int customerId;
    //@ManyToOne
    //private Product product;
    private int productId;
    private int quantity;
    private Date date;

    public Warehouse_Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


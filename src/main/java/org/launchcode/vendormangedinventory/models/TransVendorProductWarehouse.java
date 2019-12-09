package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransVendorProductWarehouse {

    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    private int id;
    private int vendorId;
    private int productId;
    private Date transactionsDate;
    private int quantity;
    private String description;
    private int warehouseId; // fom vendor to destination warehouse by delivery
                            // or from warehouse to vendor by retour
    private double price;  // For billing purpose

    public TransVendorProductWarehouse() {}
    public TransVendorProductWarehouse(int id, int vendorId, int productId,Date transactionsDate, int quantity, String description, double price){
        this.id = id;
        this.vendorId = vendorId;
        this.productId = productId;
        this.transactionsDate = transactionsDate;
        this.quantity = quantity;
        this.description = description;
        this.warehouseId = warehouseId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getTransactionsDate() {
        return transactionsDate;
    }

    public void setTransactionsDate(Date transactionsDate) {
        this.transactionsDate = transactionsDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}




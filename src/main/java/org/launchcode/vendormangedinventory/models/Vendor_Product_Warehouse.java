/*
package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Vendor_Product_Warehouse {
    @Id
    @GeneratedValue
    private int id;
    private int vendor_id;
    private int product_id;
    private int destinationWarehouse_id;
    private Date transactionsDate;
    private int quantity;
    private String description;


    public Vendor_Product_Warehouse(){}
    // This constructor will be used to create and save every delivery of product
    // in the table vendor_product_warehouse. This table will be useful for the
    // Vendor to organise his  delivery:Where to deliver which quantity
    // This Class does not need controller. It will be jointly updated
    // after a reception of product. So it use the jointly the product_controller --> add_product/reception
    public Vendor_Product_Warehouse(int vendor_id, int product_id, int destinationWarehouse_id,
                                    int quantity, String description, Date transactionsDate){
        this.setVendor_id(vendor_id);
        this.setProduct_id(product_id);
        this.setDestinationWarehouse_id(destinationWarehouse_id);
        this.setQuantity(quantity);
        this.setDescription(description);
        this.setTransactionsDate(transactionsDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getDestinationWarehouse_id() {
        return destinationWarehouse_id;
    }

    public void setDestinationWarehouse_id(int destinationWarehouse_id) {
        this.destinationWarehouse_id = destinationWarehouse_id;
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
}
*/

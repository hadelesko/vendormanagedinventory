package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction_Vendor_Product_to_or_from_Warehouse {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int vendor_id;
    private int product_id;
    private Date transactionsDate;
    private int quantity;
    private String description;
    private int from_or_to_warehouse_id; // fom vendor to destination warehouse by delivery
                                        // or from warehouse to vendor by retour
    private double price;  // For billing purpose

    public Transaction_Vendor_Product_to_or_from_Warehouse(){}

    // This constructor will be used to create and save every delivery of product
    // in the table vendor_product. This table will be useful for the
    // Vendor to organise his  delivery:Where to deliver which quantity
    // This Class does not need controller. It will be jointly updated
    // after a reception of product. So it use the jointly the product_controller --> add_product/reception

/*    public Vendor_Product(int vendor_id, int product_id, int quantity,
        String description, Date transactionsDate, int warehouseId){
        //this.id=id;
        this.vendor_id=vendor_id;
        this.product_id=product_id;
        this.quantity=quantity;
        this.description=description;
        this.transactionsDate=transactionsDate;
        this.warehouseId = warehouseId;

    }*/


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

    public int getFrom_or_to_warehouse_id() {
        return from_or_to_warehouse_id;
    }

    public void setFrom_or_to_warehouse_id(int from_or_to_warehouse_id) {
        this.from_or_to_warehouse_id = from_or_to_warehouse_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

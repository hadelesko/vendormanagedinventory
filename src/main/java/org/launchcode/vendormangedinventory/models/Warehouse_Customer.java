/*
package org.launchcode.vendormangedinventory.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Warehouse_Customer {
    */
/* To catch the flow of material between warehouse and customer
    We won't necessary create a controller for this class. This is destinated
    to record the flows of sending product to the customer or the
    RetourProduct of product from customer to the warehouse
    *//*


    @Id
    @GeneratedValue
    private int id;
    private int warehouse_id;
    private int customer_id;
    //@ManyToOne
    //private Product product;
    private int product_id;
    private int quantity;
    private Date date;

    public Warehouse_Customer() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}

*/

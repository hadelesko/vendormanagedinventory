package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer_Product {

    @Id
    @GeneratedValue
    private long id;

    private int customer_id;  // Author of the flow
    private long product_id;  // the object of the flow

    private int quantity_flowed;  // the quantity of the object(product or item) moved
    // and this is intended to update the stock of the product
    // In the controller of Customer or product business logics
    // will be developed to control the stock
    // retour, sell/buy, or destroy product
    private String description; // will be done automatically by joining the  customer id,
    // product id and the business logic that create that.

    @Temporal(TemporalType.DATE)
    private Date flow_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity_flowed() {
        return quantity_flowed;
    }

    public void setQuantity_flowed(int quantity_flowed) {
        this.quantity_flowed = quantity_flowed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFlow_date() {
        return flow_date;
    }

    public void setFlow_date(Date flow_date) {
        this.flow_date = flow_date;
    }
}
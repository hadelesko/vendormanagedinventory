/*package org.launchcode.vendormangedinventory.models;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Product_Warehouse {
    @Id
    @GeneratedValue
    private long id;
    // This class is intended to catch the flow of product
    // and so allow the update of the stored product in the warehouse(quantity)

    private int product_id;                // Which product or item is moving
    private int warehouse_id;              // From or to which  product or item is been moving

    //This can be the quantity received or produced(==> encreased the stock),
    // returned or consumed or destroyed (decrease the stock)

    private int quantity_flowed;


    *//* Which kind of the flow is it; Reception, retour, destruction or consumption? The stock will be accordingly
    be updated. The kind of the flow will be specified in the Controller where the
    business logic(method receive(Product), return(Product), product(newProduct), destroy(product)) will be developed
    This business method will update the existing stock of the product or the list of the products
     *//*
    private String description;

    @Temporal(TemporalType.DATE) // Date to follow every flow
    private Date flow_date;


    public Product_Warehouse() {
    }

<<<<<<< HEAD
}
=======
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
}*/
>>>>>>> ear_reviews

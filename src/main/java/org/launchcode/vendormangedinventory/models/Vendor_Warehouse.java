package org.launchcode.vendormangedinventory.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
public class Vendor_Warehouse {
    @Id
    @GeneratedValue
    private int id;

    private long vendor_id;
    private long warehouse_id;

/*    @ManyToOne
    private Product product;
    @NotNull
    private int quantity_delivered;*/

/*    @OneToMany
    private Warehouse destinationWarehouse;*/

    public Vendor_Warehouse (){}

}

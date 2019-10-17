package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Vendor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Embedded
    private Address address;

    @ManyToOne
    private Product product;

    /*One vendor can deliver or store product in one or more warehouses
    *  mappedBy="deliveries" to refer to the join table delivery in the warehouse entity
    *
    * */

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="Vendor_Warehouse",
    joinColumns = {@JoinColumn(name="vendor_id")},
    inverseJoinColumns = {@JoinColumn(name="warehouse_id")})
    private List<Warehouse> warehouseList =new ArrayList<>();

    public Vendor(){}
}

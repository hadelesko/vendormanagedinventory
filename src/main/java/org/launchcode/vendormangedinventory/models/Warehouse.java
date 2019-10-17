package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany
    private List<Product> listProducts;

    @ManyToMany
    private List<Customer> listCustomers;

    /*mappedBy="warehouseList"to refer to the join-table "vendor_warehouse" that means
    * when the vendor deliver product to the warehouse, this will be recorded
    *  in the join-table  "vendor_warehouse". to indicate the vendor deliver a product
    * to the warehouse */
    @ManyToMany(mappedBy="warehouseList")
    private List<Vendor> listVendors =new ArrayList<Vendor>();

    /*  @ManyToOne
    private Sale sale;*/

    @Embedded
    private Address address;
    public Warehouse(){}

}

package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    @ManyToMany
    private List<Product> listProducts;
    @ManyToMany
    private List<Customer> listCustomers;
    @ManyToMany
    private List<Vendor> listVendors;
    @ManyToOne
    private List<Sale> listSales;
    public Warehouse(){}

}

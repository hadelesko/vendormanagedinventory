package org.launchcode.vendormangedinventory.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=5, message="At least 5 characters")
    private String name;

    @ManyToMany
    private List<Product> products=new ArrayList<>();

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="Warehouse_Customer",
            joinColumns = {@JoinColumn(name = "warehouse_id") },
            inverseJoinColumns = {@JoinColumn(name = "customer_id")})
    //@ManyToMany
    private Set<Customer> customers; //=new HashSet<Customer>(); // no need to new HashSet Customer here

    /*mappedBy="warehouseList"to refer to the join-table "vendor_warehouse" that means
    * when the vendor deliver product to the warehouse, this will be recorded
    *  in the join-table  "vendor_warehouse". to indicate the vendor deliver a product
    * to the warehouse */
    @ManyToMany(mappedBy="warehouseList")
    private Set<Vendor> listVendors =new HashSet<>();

    /*  @ManyToOne
    private Sale sale;*/

    @Embedded
    @Basic
    private Address address;
    public Warehouse(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Vendor> getListVendors() {
        return listVendors;
    }

    public void setListVendors(Set<Vendor> listVendors) {
        this.listVendors = listVendors;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

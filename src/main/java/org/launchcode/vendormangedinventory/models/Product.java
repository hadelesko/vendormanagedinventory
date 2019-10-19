package org.launchcode.vendormangedinventory.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @Size(min = 5, message = "At least 5 character")
    private String name;

    //@Pattern(regexp = "[1-9]+")
    private int quantity;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vendor> vendorList;

    @ManyToMany(mappedBy = "listBoughtProduct")  // refers to the fields in customer-Table  'listBoughtProduct'
    private List<Customer> customers = new ArrayList<Customer>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "product_warehouse",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "warehouse_id")})
    private Set<Warehouse> warehouseList = new HashSet<>();


    //@Pattern(regexp = "[1-9]*\\.[0-9]{2}")
    @DecimalMin(value="1.00") @DecimalMax(value="99999.00",  message="must be at least $1 and can not be greater than $99999")
    private double price;

    @NotNull
    private String description;


    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Set<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(Set<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

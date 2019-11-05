package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Embedded
    private Address address;

/*    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="Customer_Product",
            joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id")})*/
    @ManyToMany
    private List<Product>listBoughtProduct; //=new ArrayList<Product>();

    @ManyToMany(mappedBy="customers")
    private List<Warehouse>warehouses=new ArrayList<Warehouse>();

    public Customer(){}

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getListBoughtProduct() {
        return listBoughtProduct;
    }

    public void setListBoughtProduct(List<Product> listBoughtProduct) {
        this.listBoughtProduct = listBoughtProduct;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    /*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="purchaseId")
    private List<Purchase> listPurchase;
    @ManyToOne
    private Sale boughtList;*/



}

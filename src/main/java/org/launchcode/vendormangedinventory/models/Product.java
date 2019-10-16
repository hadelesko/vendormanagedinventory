package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double quantity;
    @OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Vendor> listVendor;
}

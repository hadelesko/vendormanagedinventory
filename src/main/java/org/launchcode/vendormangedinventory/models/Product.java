package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double quantity;
    @OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL , mappedBy ="product")
    private List<Vendor> vendorList;
}

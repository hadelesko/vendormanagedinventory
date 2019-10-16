package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
public class Sale {
    @Id
    @GeneratedValue
    private  int id;
    //@OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Map<Product,Double>> listProduct=new ArrayList<Map<Product,Double>>();
    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Customer customer;
    public Sale(){}
}

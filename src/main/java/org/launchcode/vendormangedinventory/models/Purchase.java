package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
public class Purchase {
    private  int id;
    private List<Map<Product,Double>> listProduct=new ArrayList<Map<Product, Double>>();
    private Customer customer;
    public Purchase(){}

}

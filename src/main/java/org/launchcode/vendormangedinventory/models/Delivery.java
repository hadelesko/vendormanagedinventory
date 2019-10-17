/*package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private int id;
    private List<Map<Product, Double>> listProduct=new ArrayList<Map<Product, Double>>();

    @OneToMany
    private Warehouse destinationWarehouse;
    public Delivery (){}

}*/

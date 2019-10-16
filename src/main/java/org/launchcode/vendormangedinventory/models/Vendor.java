package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Vendor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private List<Product> listProduct;
    private List<Warehouse>listWarehouse;

    public Vendor(){}
}

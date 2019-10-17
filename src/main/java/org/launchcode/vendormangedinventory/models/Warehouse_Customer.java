package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Warehouse_Customer {
    @Id
    @GeneratedValue
    private int id;
    private int warehouse_id;
    private long customer_id;

}

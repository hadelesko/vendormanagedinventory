package org.launchcode.vendormangedinventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private List<Purchase> listPurchase;
}

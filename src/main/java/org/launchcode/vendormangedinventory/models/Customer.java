package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Embedded
    private Address address;

    
    /*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="purchaseId")
    private List<Purchase> listPurchase;
    @ManyToOne
    private Sale boughtList;*/

}

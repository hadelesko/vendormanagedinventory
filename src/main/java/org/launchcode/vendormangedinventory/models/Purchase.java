/*package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Purchase{
    @Id
    @GeneratedValue
    private  long id;

    @ManyToOne
    Product listProduct;
    @ManyToOne
    private Customer customer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
    public Purchase(){}

}*/

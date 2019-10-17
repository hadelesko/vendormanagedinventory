/*package org.launchcode.vendormangedinventory.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Entity
public class Sale {
    @Id
    @GeneratedValue
    private  long id;
    //@OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    @ManyToOne
    private Product product;

    //mappedBy= "boughtList" refers to the column 'boughtList' in the table "Customer"
    @OneToMany(mappedBy= "boughtList", fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Customer customer;

    //mappedBy= "sale" refers to the column 'sale' in the table "Warehouse"
    @OneToMany(mappedBy = "sale", fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Warehouse>warehouseList;
    public Sale(){}
}*/

package org.launchcode.vendormangedinventory.models;

import javax.persistence.Embeddable;

@Embeddable //for use by customer, warehouse, vendor
public class Address {
    private String street;
    private String zipCode;
    private String country;
    private String city;
    private String phone;
    private String fax;
}

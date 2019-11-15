package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.Customer;
import org.launchcode.vendormangedinventory.models.Vendor;
import org.launchcode.vendormangedinventory.models.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value="customer")
public class CustomerController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private VendorDao vendorDao;
    @Autowired
    private Vendor_ProductDao vendor_productDao;

    @Autowired
    private WarehouseDao warehouseDao;

    @Autowired
    private Vendor_Product_WarehouseDao vendor_product_warehouseDao;
    @Autowired
    private CustomerDao customerDao;
    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "List of the customers");
        model.addAttribute("customers",customerDao.findAll());
        return "customer/index";
    }


      @RequestMapping(value="vendis")
        @ResponseBody
        public Customer getCustomer(){
           Customer cust=customerDao.findById(1);

            return cust;
        }
    }



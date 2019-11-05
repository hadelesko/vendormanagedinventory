package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.Product;
import org.launchcode.vendormangedinventory.models.TransVendorProductWarehouse;
import org.launchcode.vendormangedinventory.models.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="transactions")
public class TransactionsController {
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

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "List of the transactions of products between vendors warehouses and customers");
        model.addAttribute("transactions",vendor_product_warehouseDao.findAll());
        return "home/transactions";

    }
    @RequestMapping(value="id={id}")// "name={name}", "quantity={quantity}", "warehouse={warehouseId}" })
    public String editSingleObjectById(Model model,@PathVariable int id) {
        List<TransVendorProductWarehouse> transactions = new ArrayList<>();
        if (vendor_product_warehouseDao.findById(id) == null) {
            model.addAttribute("title", "Search for transaction with  id =" + id + "  No transaction with the specified id");
            model.addAttribute("transactions", transactions);
        } else {
            transactions.add(vendor_product_warehouseDao.findById(id));
            model.addAttribute("title", "Result of the search for transaction with  id =" + id + " is the following");
            model.addAttribute("transactions", transactions);
        }
        return "home/transactions";
    }


}

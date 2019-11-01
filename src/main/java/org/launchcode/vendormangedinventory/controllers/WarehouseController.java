package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.Address;
import org.launchcode.vendormangedinventory.models.TransVendorProductWarehouse;
import org.launchcode.vendormangedinventory.models.Vendor;
import org.launchcode.vendormangedinventory.models.Warehouse;
import org.launchcode.vendormangedinventory.models.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value="warehouse")
public class WarehouseController {
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

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "List of Warehouses");
        model.addAttribute("warehouses",warehouseDao.findAll());
        return "warehouse/index";
    }

    @RequestMapping(value = {"create", "add"}, method = RequestMethod.GET)
    public String createWarehouse(Model model) {
        model.addAttribute("tile", "Create new warehouse");
        model.addAttribute(new Warehouse());
        model.addAttribute(new Address());
        return "warehouse/add";
    }

    @RequestMapping(value = {"create", "add"}, method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Warehouse warehouse,
                               @ModelAttribute @Valid Address address, @RequestParam Map<String,String>requestParams,
                               Errors errors) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new Warehouse");
            return "warehouse/add";
        }
        address.setEmail(requestParams.get("email"));
        address.setPassword(requestParams.get("password"));
        address.setCity(requestParams.get("city"));
        address.setCountry(requestParams.get("country"));
        address.setZipCode(requestParams.get("zipCode"));
        address.setStreet(requestParams.get("street"));
        address.setPhone(requestParams.get("phone"));
        address.setFax(requestParams.get("fax"));
        //model.addAttribute("address", address);

        warehouse.setAddress(address);

        warehouseDao.save(warehouse);
        return "warehouse/add";
    }

    // Search for vendors of specific product
    @RequestMapping(value="vendors/productId={productId}")
    public String editVendorsOfProduct(Model model,@PathVariable int productId){
        Set<Vendor> vendorsOfThisProduct= new HashSet<Vendor>();
        Vendor transactionVendor=new Vendor();
        for(TransVendorProductWarehouse productTrans : vendor_product_warehouseDao.findByProductId(productId)){
            transactionVendor=vendorDao.findById(productTrans.getVendorId());
            vendorsOfThisProduct.add(transactionVendor);
        }
        model.addAttribute("title", "Vendors of the product with id="+productId+" : '"+productDao.findById(productId).getName()+"' are the following");
        model.addAttribute("vendors", vendorsOfThisProduct);
        return "/vendor/edit";
    }

}
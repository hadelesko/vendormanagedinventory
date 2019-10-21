package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.Address;
import org.launchcode.vendormangedinventory.models.Product;
import org.launchcode.vendormangedinventory.models.Vendor;
import org.launchcode.vendormangedinventory.models.daos.ProductDao;
import org.launchcode.vendormangedinventory.models.daos.VendorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value="vendor")
public class VendorController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private VendorDao vendorDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("tile", "Add vendor");
        model.addAttribute(new Vendor());
        model.addAttribute(new Address());
        model.addAttribute("products", productDao.findAll());
        return "vendor/addvendor";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Vendor vendor,
                               @ModelAttribute @Valid Address address,
                               @RequestParam("productId") long productId,
                               @RequestParam Map<String,String> requestParams, Errors errors) {

        Product product=productDao.findOne(productId);
        Set<Product> listOfProducts= new HashSet<Product>(); //initialize the list of product
                                                            // supplied by this vendor

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            model.addAttribute("products", productDao.findAll());
            return "vendor/addvendor";
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

        vendor.setAddress(address);

        vendorDao.save(vendor);
        productDao.findOne(productId).getVendorList().add(vendor);


        model.addAttribute("products", productDao.findAll());
        return "vendor/addvendor";
    }
}

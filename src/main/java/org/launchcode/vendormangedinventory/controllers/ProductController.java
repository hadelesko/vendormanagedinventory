package org.launchcode.vendormangedinventory.controllers;


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

@Controller
@RequestMapping(value={"product", "item"})
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private VendorDao vendorDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "List of the products");
        model.addAttribute("products",productDao.findAll());
        return "product/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("title", "Reception of product");
        model.addAttribute(new Product());
        model.addAttribute(new Vendor());
        model.addAttribute("vendors", vendorDao.findAll());
        return "product/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Product product,
                               @RequestParam ("id_of_vendor_of_this_product") int id_of_vendor_of_this_product,
                               Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            return "product/add";
        }
        productDao.save(product);
        return "redirect:";
    }

}

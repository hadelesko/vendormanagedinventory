package org.launchcode.vendormangedinventory.controllers;


import org.launchcode.vendormangedinventory.models.Product;
import org.launchcode.vendormangedinventory.models.daos.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value={"product", "item"})
public class ProductController {
    @Autowired
    private ProductDao productDao;
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("tile", "Add product");
        model.addAttribute(new Product());
        return "product/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Product product, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            return "product/add";
        }
        productDao.save(product);
        return "product/add";
    }

}

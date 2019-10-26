package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.*;
import org.launchcode.vendormangedinventory.models.daos.ProductDao;
import org.launchcode.vendormangedinventory.models.daos.VendorDao;
import org.launchcode.vendormangedinventory.models.daos.Vendor_ProductDao;
import org.launchcode.vendormangedinventory.models.daos.WarehouseDao;
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
    @Autowired
    private Vendor_ProductDao vendor_productDao;

    @Autowired
    private WarehouseDao warehouseDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("title", "List of the vendors");
        model.addAttribute("vendors",vendorDao.findAll());
        return "vendor/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("title", "Add a new vendor");
        model.addAttribute(new Vendor());
        model.addAttribute(new Address());
        // To add a new vendor with new product i.e  both vendor and product are new
       // model.addAttribute("isNotProductId", 0);
        model.addAttribute("products", productDao.findAll());
        return "vendor/addvendor";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Vendor vendor,
                               @ModelAttribute @Valid Address address,
                               @RequestParam("productId") int productId,
                               @RequestParam Map<String,String> requestParams, Errors errors) {

        Product product=productDao.findOne(productId);
        Set<Product> listOfProducts= new HashSet<Product>(); //initialize the list of product
                                                            // supplied by this vendor

        if (errors.hasErrors()) {
            model.addAttribute("title", "Welcome to the vendor managed inventory system . Add new vendor");
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
        vendor.setProduct(product); // this allow us to associate the product
        // to this vendor before saving. Without this setting the column product_id in the table vendor will be 'NULL'
        vendorDao.save(vendor);
        productDao.findOne(productId).getVendorList().add(vendor);


        model.addAttribute("products", productDao.findAll());

        // REDIRECT TO THE RECEPTION REGISTRATION AFTER RECORD OR THE NEW VENDOR
        // For the redirection to product/add, we need to add the following  attributes to the model


/*      model.addAttribute("title", "Reception of product");
        model.addAttribute(new Product());
        model.addAttribute(new Vendor());
        model.addAttribute(new Warehouse());
        model.addAttribute(new Transaction_Vendor_Product_to_or_from_Warehouse());
        model.addAttribute("notVendorId",0);*/


        // this id =0 does not exist. we just give
        // here to give that to the notVendorId track the case when someone
        // want to add a product which Vendor is not yet recorded in the system

/*      model.addAttribute("vendors", vendorDao.findAll());
        model.addAttribute("warehouses", warehouseDao.findAll());
        model.addAttribute("title", "Now, you can register the new Reception of product");*/

        return "redirect:/product/add";
    }
}

package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.*;
import org.launchcode.vendormangedinventory.models.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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

    @Autowired
    private Vendor_Product_WarehouseDao vendor_product_warehouseDao;

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

        return "redirect:/product/add";
    }
    @RequestMapping(value="id={id}")// "name={name}", "warehouse={warehouseId}" })
    public String editSingleObject(Model model,@PathVariable int id) {
        List<Vendor> vendors = new ArrayList<>();
        if (vendorDao.findById(id) == null) {
            model.addAttribute("title", "Search for vendor with  id =" + id + "  No vendor with the specified id");
            model.addAttribute("vendors", vendors);
        } else {
            vendors.add(vendorDao.findById(id));
            model.addAttribute("title", "Result of the search for vendor with  id =" + id + " is the following");
            model.addAttribute("vendors", vendorDao.findById(id));
        }
        return "vendor/edit";
    }

    @RequestMapping(value="name={name}")// "name={name}", "warehouse={warehouseId}" })
    public String editbyName(Model model,@PathVariable String name) {
        List<Vendor> vendors = new ArrayList<>();
        String title="";
        if (vendorDao.findByName(name) == null) {
            title="Search for vendor with  id =" + name + "  No vendor with the specified id";
        } else {
            vendors.add(vendorDao.findByName(name));
            title= "Result of the search for vendor with  id =" + name + " is the following";

        }
        model.addAttribute("title", title);
        model.addAttribute("vendors", vendors);
        return "vendor/edit";
    }

    // search for partner - warehouses of specific vendor. For example: which warehouses the vendor with id= X deliver product?
    @RequestMapping(value={"id={vendorId}/warehouses", "{vendorId}/warehouses"})
    public String getVendorsWarehouses(Model model, @PathVariable int vendorId){
        Set<Warehouse>deservedWarehouses= new HashSet<Warehouse>();
        Warehouse transactionWarehouse=new Warehouse();
        String title="";
        if(vendorDao.findById(vendorId)!=null && vendor_product_warehouseDao.findByVendorId(vendorId).size()!=0) {
            for (TransVendorProductWarehouse trans : vendor_product_warehouseDao.findByVendorId(vendorId)) {
                transactionWarehouse = warehouseDao.findById(trans.getWarehouseId());
                deservedWarehouses.add(transactionWarehouse);
            }
            title = String.format("The warehouse(s) deserved by the vendor with \nid=%1$s: %2$s", vendorId, vendorDao.findById(vendorId).getName());
        }

        else {
            if (vendorDao.findById(vendorId) != null && vendor_product_warehouseDao.findByVendorId(vendorId).size() == 0) {
                title = String.format("This vendor id=%1$s just been registered and no transaction(delivery) \nhas been recorded for him", vendorId);
            } else {
                if (vendorDao.findById(vendorId) == null) {
                    title = String.format("No vendor with such id=%1$s in the system, so no warehouse", vendorId);
                }
            }
        }
        model.addAttribute("title", title);
        model.addAttribute("warehouses",deservedWarehouses);
        return "/warehouse/index";
    }

    @RequestMapping(value="productId={productId}")
    public String getVendorsForproduct(@PathVariable("productId") int productId, Model model){
        Product product=productDao.findById(productId);
        List<Vendor>vendors=vendorDao.findByProduct(product);
        model.addAttribute("title", "vendors for the product with id= "+productId+ " name= "+product.getName());
        model.addAttribute("vendors", vendors);
        return "vendor/edit";
    }

}

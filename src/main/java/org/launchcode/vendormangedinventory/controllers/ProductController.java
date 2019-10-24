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
import java.util.Date;

@Controller
@RequestMapping(value={"product", "item"})
public class ProductController {

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
        model.addAttribute("title", "List of the products");
        model.addAttribute("products",productDao.findAll());
        return "product/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("title", "Reception of product");
        model.addAttribute(new Product());
        model.addAttribute(new Vendor());
        model.addAttribute(new Warehouse());
        model.addAttribute(new Transaction_Vendor_Product_to_or_from_Warehouse());
        model.addAttribute("notVendorId",0); // this id =0 does not exist. we just give
        // here to give that to the notVendorId track the case when someone
        // want to add a product which Vendor is not yet recorded in the system
        model.addAttribute("vendors", vendorDao.findAll());
        model.addAttribute("warehouses", warehouseDao.findAll());
        return "product/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addProductProcess(Model model, @ModelAttribute @Valid Product product,
                               @RequestParam ("id_of_vendor_of_this_product") int id_of_vendor_of_this_product,
                               @RequestParam("destinationWarehouse") int destinationWarehouseId,
                               Errors errors) {

        Warehouse destinationWarehouse=warehouseDao.findOne(destinationWarehouseId);
        //String path="";
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            //path="product/add";
            return "product/add";
        } else {
            if(id_of_vendor_of_this_product == 0) { // we have no vendor with id=0
                model.addAttribute("title", "Add the new vendor before adding the product you received");
                model.addAttribute("products", productDao.findAll());
                model.addAttribute(new Vendor());
                model.addAttribute(new Address());
                return "redirect:/vendor/add";
            }else {
                Vendor currentVendor = vendorDao.findById(id_of_vendor_of_this_product);
                //Set<Vendor> vendorListOfThisProduct=.;
                if(productDao.findByName(product.getName())!=null) { // Case product exists
                    int productId=productDao.findByName(product.getName()).getId();
                    int newStock=productDao.findByName(product.getName()).getQuantity()+product.getQuantity();

                    //update
                    //productDao.findById(productId).getVendorList().add(currentVendor);
                    product.getWarehouseList().add(warehouseDao.findOne(destinationWarehouseId));
                    productDao.findById(productId).setQuantity(newStock);

                }else{
                    //product.getId();
                    productDao.save(product);
                }
                int productId=productDao.findByName(product.getName()).getId();
                Date deliveryDate=new Date();
                String description="Reception of product '" +product.getName();

                //Vendor_Product( int vendor_id, int product_id, int quantity, String description, Date transactionsDate)
                Transaction_Vendor_Product_to_or_from_Warehouse delivery=new Transaction_Vendor_Product_to_or_from_Warehouse();
                delivery.setVendor_id( id_of_vendor_of_this_product);
                delivery.setProduct_id(productId);
                delivery.setQuantity(product.getQuantity());
                delivery.setDescription(description);
                delivery.setTransactionsDate(deliveryDate);
                delivery.setFrom_or_to_warehouse_id(destinationWarehouseId);
                delivery.setPrice(product.getPrice());
                vendor_productDao.save(delivery);
                return "redirect:";
                }
            }
        }
}

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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

        List<Warehouse>warehouseListForTheReceivedProduct= (List<Warehouse>) product.getWarehouseList();
        Warehouse destinationWarehouse=warehouseDao.findById(destinationWarehouseId);
        //String path="";
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            //path="product/add";
            return "product/add";
        } else {
            if(id_of_vendor_of_this_product == 0) { // we have no vendor with id=0
    /*           model.addAttribute("title", "Add the new vendor before adding the product you received");
                model.addAttribute("products", productDao.findAll());
                model.addAttribute(new Vendor());
                model.addAttribute(new Address());*/
                return "redirect:/vendor/add";
            }else {
                Vendor currentVendor = vendorDao.findById(id_of_vendor_of_this_product);
                //Set<Vendor> vendorListOfThisProduct=.;
                if(productDao.findByName(product.getName())!=null) { // Case product exists
                    int productId=productDao.findByName(product.getName()).getId();
                    int newStock=productDao.findByName(product.getName()).getQuantity()+product.getQuantity();

                    //update
                    //productDao.findById(productId).getVendorList().add(currentVendor);

                    product.getWarehouseList().add(destinationWarehouse);
                    productDao.findById(productId).setQuantity(newStock);

                }else{
                    //product.getId();
                    product.getWarehouseList().add(destinationWarehouse);
                    
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

                product.getWarehouseList().add(destinationWarehouse);
                vendor_productDao.save(delivery);
                return "redirect:";
                }
            }
        }
/*        @RequestMapping(value={"id={id}", "name={name}", "quantity={quantity}", "warehouse={warehouseId}" })
        public String editSingleObject(Model model,
                                       @PathVariable int id, @PathVariable String name,
                                       @PathVariable int quantity, @PathVariable int warehouseId){

            List<Product>searchTerms=new ArrayList<>();
            String s_id=String.valueOf(id);
            String s_name=String.valueOf(name);
            String s_quantity=String.valueOf(quantity);
            String s_warehouseId=String.valueOf(warehouseId);



            model.addAttribute("title","Search for product with ...="+searchTermValue);
        }*/

    @RequestMapping(value="id={id}")// "name={name}", "quantity={quantity}", "warehouse={warehouseId}" })
    public String editSingleObject(Model model,@PathVariable int id) {
        List<Product> products = new ArrayList<>();
        if (productDao.findById(id) == null) {
            model.addAttribute("title", "Search for product with  id =" + id + "  No product with the specified id");
            model.addAttribute("products", products);
        } else {
            products.add(productDao.findById(id));
            model.addAttribute("title", "Result of the search for product with  id =" + id + " is the following");
            model.addAttribute("products", productDao.findById(id));
        }
        return "product/edit";
    }
}

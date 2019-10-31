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

    @Autowired
    private Vendor_Product_WarehouseDao vendor_product_warehouseDao;

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
        model.addAttribute(new TransVendorProductWarehouse());
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

        //Set<Warehouse>warehouseListForTheReceivedProduct= (List<Warehouse>) product.getWarehouseList();
        Warehouse destinationWarehouse=warehouseDao.findById(destinationWarehouseId);
        //String path="";
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            //path="product/add";
            return "product/add";
        } else {
            if(id_of_vendor_of_this_product == 0) { // we have no vendor with id=0

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
                    //product.getWarehouseList().add(destinationWarehouse);
                    //product.setId(product.getId());
                    productDao.save(product);
                }
                int productId=productDao.findByName(product.getName()).getId();
                Date deliveryDate=new Date();
                String description="Reception of product '" +product.getName();

                //Vendor_Product( int vendor_id, int product_id, int quantity, String description, Date transactionsDate)
                TransVendorProductWarehouse delivery=new TransVendorProductWarehouse();
                delivery.setVendorId( id_of_vendor_of_this_product);
                delivery.setProductId(productId);
                delivery.setQuantity(product.getQuantity());
                delivery.setDescription(description);
                delivery.setTransactionsDate(deliveryDate);
                delivery.setWarehouseId(destinationWarehouseId);
                delivery.setPrice(product.getPrice());

                //product.getWarehouseList().add(destinationWarehouse);
                vendor_productDao.save(delivery);
                return "redirect:";
            }
        }
    }

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

    @RequestMapping(value="name={name}")// "name={name}", "quantity={quantity}", "warehouse={warehouseId}" })
    public String editbyName(Model model,@PathVariable String name) {
        List<Product> products = new ArrayList<>();
        String title="";
        if (productDao.findByName(name) == null) {
           title="Search for product with  id =" + name + "  No product with the specified id";
        } else {
            products.add(productDao.findByName(name));
            title= "Result of the search for product with  id =" + name + " is the following";
        }
        model.addAttribute("title", title);
        model.addAttribute("products", products);
        return "product/edit";
    }

    @RequestMapping(value="vendors/id={productId}")
    public String editVendorsOfProduct(Model model,@PathVariable int productId){
        Set<Vendor>vendorsOfThisProduct= new HashSet<Vendor>();
        Vendor transactionVendor=new Vendor();
        for(TransVendorProductWarehouse productTrans : vendor_product_warehouseDao.findByProductId(productId)){
            transactionVendor=vendorDao.findById(productTrans.getVendorId());
            vendorsOfThisProduct.add(transactionVendor);
        }
        model.addAttribute("title", "Vendors of the product with id="+productId+" are the following");
        model.addAttribute("vendors", vendorsOfThisProduct);
        return "/vendor/edit";
    }

}

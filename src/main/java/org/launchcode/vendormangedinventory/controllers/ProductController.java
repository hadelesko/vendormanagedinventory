package org.launchcode.vendormangedinventory.controllers;


import org.launchcode.vendormangedinventory.models.*;
import org.launchcode.vendormangedinventory.models.daos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private CustomerDao customerDao;

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
                                    //@RequestPart("pictures")List<MultipartFile>pictures,
                                    Errors errors) {

        //Set<Warehouse>warehouseListForTheReceivedProduct= (List<Warehouse>) product.getWarehouseList();
        Warehouse destinationWarehouse=warehouseDao.findById(destinationWarehouseId);
        Set<Vendor> vendorListOfThisProduct= new HashSet<>();
        Set<Warehouse> warehousesListOfThisProduct= new HashSet<>();

        //String path="";
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new product");
            //path="product/add";
            return "product/add";
        } else {
            if(id_of_vendor_of_this_product == 0) { // we have no vendor with id=0

                return "redirect:/vendor/add";
            }else{

                Vendor currentVendor = vendorDao.findById(id_of_vendor_of_this_product);


                if(productDao.findByName(product.getName())!=null) { // Case product exists
                    int productId=productDao.findByName(product.getName()).getId();
                    int newStock=productDao.findByName(product.getName()).getQuantity()+product.getQuantity();
                    //update
                    //Update the warehouse list
                    //warehousesListOfThisProduct.addAll(productDao.findByName(product.getName()).getWarehouseList());

                    //vendor_product_warehouseDao.findByProductId(productId).forEach(transs->warehousesListOfThisProduct.add(warehouseDao.findById(transs.getWarehouseId())));
                    for(TransVendorProductWarehouse transs: vendor_product_warehouseDao.findByProductId(productId)){
                        warehousesListOfThisProduct.add(warehouseDao.findById(transs.getWarehouseId()));
                    }

                    warehousesListOfThisProduct.add(destinationWarehouse); // add the current warehouse
                    //Update the vendor list of the product
                    //vendorListOfThisProduct.addAll(productDao.findByName(product.getName()).getVendorList());
                    vendorListOfThisProduct.add(currentVendor); // add the current vendor

                    //update in the database
                    productDao.findById(productId).setQuantity(newStock);  // Stock update

                    //productDao.findById(productId).setVendorList(vendorListOfThisProduct);  // Update the vendor list
                    //productDao.findById(productId).setWarehouses(warehousesListOfThisProduct);  //warehouse list update

                }else{ //Product does not exist


                    productDao.save(product);
                    productDao.findByName(product.getName()).getWarehouses().add(destinationWarehouse);
                    productDao.findByName(product.getName()).getVendorList().add(currentVendor);

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

    @RequestMapping(value = {"search", "find"}, method = RequestMethod.GET)
    public String getSearch(Model model) {
        model.addAttribute("title", "Search product(s)");

        model.addAttribute(new TransVendorProductWarehouse());
        model.addAttribute("vendors", vendorDao.findAll());
        model.addAttribute("warehouses", warehouseDao.findAll());
        model.addAttribute("id", "id");
        model.addAttribute("name", "name");
        model.addAttribute("quantity", "quantity");
        model.addAttribute("searchTermValue");
        return "product/search";
    }


    @RequestMapping(value={"search", "find"}, method = RequestMethod.POST)
    public String postSearch(Model model, @RequestParam ("searchCriteria") String searchCriteria,
                             @RequestParam("searchTermValue") String searchTermValue) {
        List<Product> products = new ArrayList<>();
        String title = "";
        Product product = new Product();
        if (searchCriteria.equals("name")) {
            products.add(productDao.findByName(searchTermValue));
            title = products.size() == 0 ? "No product with the given name=" + searchTermValue : "Result of the search product name = " + searchTermValue + " is";
            model.addAttribute("title", title);
            model.addAttribute("products", products);
            return "redirect:/product/name=" + searchTermValue;
        } else {
            int searchValue = Integer.parseInt(searchTermValue);
            if (searchCriteria.equals("id") && productDao.findById(searchValue) != null) {

                products.add(productDao.findById(searchValue));
                title = "No product with the given name";
                model.addAttribute("title", title);
                model.addAttribute("products", products);

                return "redirect:/product/id" + searchValue;
            } else {
                if (searchCriteria.equals("quantity") && productDao.findByQuantityLessThan(searchValue) != null) {
                    productDao.findByQuantityLessThan(searchValue).forEach(prod -> products.add(prod));
                    title = "Result of the search product name = " + searchTermValue + " is";
                    model.addAttribute("title", title);
                    model.addAttribute("products", products);
                    //return "product/edit";
                }

            }


        }

        return "product/edit";
        }


        @RequestMapping(value="retour", method=RequestMethod.GET)
        public String getRetourToVendorForm(Model model){
            List<String>motifsOfRetour=new ArrayList<>();
            //["Quality", "Default", "Functionality","No need now", "Enough in stock"];
            motifsOfRetour.add("Quality");
            motifsOfRetour.add("Default");
            motifsOfRetour.add("Functionality");
            motifsOfRetour.add("No need now");
            motifsOfRetour.add("Enough in stock");
            model.addAttribute("title", "Retour of product to the vendor");
            model.addAttribute(new TransVendorProductWarehouse());
            model .addAttribute("products", productDao.findAll());
            model.addAttribute("vendors", vendorDao.findAll());
            model.addAttribute("warehouses", warehouseDao.findAll());
            model.addAttribute("motifsOfRetour", motifsOfRetour);
            model.addAttribute("product", new Product());
            return "product/retour";
        }
    @RequestMapping(value="retour", method=RequestMethod.POST)
    public String postRetourToVendor(Model model,@RequestParam("quantity") int quantityReturned,
                                     @RequestParam ("productId") int productId,
                                     @RequestParam("sourceWarehouseId") int sourceWarehouseId,
                                     @RequestParam ("vendorId") int vendorId,
                                     @RequestParam ("description") String description){

        int currentStock=productDao.findById(productId).getQuantity();
        Product selectedProduct=productDao.findById(productId);
        Set<Warehouse>productWarehouses=new HashSet<>();
        Set<Vendor>productVendors=new HashSet<>();

        productVendors.addAll(vendorDao.findByProduct(selectedProduct));
        Vendor vendorSelected=vendorDao.findById(vendorId);
        Warehouse selectedWarehouse=warehouseDao.findById(sourceWarehouseId);


        //productWarehouses.addAll(productDao.findById(productId).getWarehouseList());

        for(TransVendorProductWarehouse trans: vendor_product_warehouseDao.findByProductId(productId)){
            productWarehouses.add(warehouseDao.findById(trans.getWarehouseId()));
        }

        if(quantityReturned<=productDao.findById(productId).getQuantity()
                && productWarehouses.contains(selectedWarehouse)
                && productVendors.contains(vendorSelected)){
            TransVendorProductWarehouse retour=new TransVendorProductWarehouse();
            //Date retourDate=new Date();
            int newstock=currentStock-quantityReturned;
            retour.setDescription(description);
            retour.setQuantity(quantityReturned);
            retour.setTransactionsDate(new Date());
            retour.setProductId(productId);
            retour.setVendorId(vendorId);
            retour.setWarehouseId(sourceWarehouseId);
            retour.setPrice(selectedProduct.getPrice());
            vendor_product_warehouseDao.save(retour);

            productDao.findById(productId).setQuantity(newstock);
            return "product/edit";
        }
        else{
            String title1=quantityReturned<=productDao.findById(productId).getQuantity()?  "" : selectedProduct.getName()+": max. quantity= "+ selectedProduct.getQuantity() +".  ";
            String title2=productWarehouses.contains(selectedWarehouse)? "" : "This warehouse ="+selectedWarehouse.getName()+ "  has not the product = "+selectedProduct.getName()+".  ";
            String title3= productVendors.contains(vendorSelected)? ""  :  "The selected Vendor = "+vendorSelected.getName()+" is not the right vendor for the product = "+selectedProduct.getName();

            String title= title1+" \n "+title2+" \n "+title3;
            model.addAttribute("title", title);

            List<String>motifsOfRetour=new ArrayList<>();
            //["Quality", "Default", "Functionality","No need now", "Enough in stock"];
            motifsOfRetour.add("Quality");
            motifsOfRetour.add("Default");
            motifsOfRetour.add("Functionality");
            motifsOfRetour.add("No need now");
            motifsOfRetour.add("Enough in stock");
            model .addAttribute("products", productDao.findAll());

            model.addAttribute("vendors", vendorDao.findAll());
            model.addAttribute("warehouses", warehouseDao.findAll());
            model.addAttribute("motifsOfRetour", motifsOfRetour);
            return  "product/retour";
        }



    }


//===================================================================================================
    @RequestMapping(value="flow/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public TransVendorProductWarehouse flow(@PathVariable int id){
            //TransVendorProductWarehouse trans=new TransVendorProductWarehouse();
        //int transId= Integer.parseInt(id);
            for(TransVendorProductWarehouse tr: vendor_product_warehouseDao.findAll()){
                if(tr.getId()==id){
                    return tr;
                }

            }
            return null;
    }

    @RequestMapping(value="flows", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<TransVendorProductWarehouse>flows() {
        //TransVendorProductWarehouse trans=new TransVendorProductWarehouse();
        List<TransVendorProductWarehouse>tvpw=new ArrayList<>();
        vendor_product_warehouseDao.findAll().forEach(trans->tvpw.add(trans));
        return tvpw;

    }


//===================================================================================================
@RequestMapping(value="vendis")
@ResponseBody
public Product getProd() {
    Product prod = productDao.findById(6);

    return prod;

}
}

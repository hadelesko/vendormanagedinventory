package org.launchcode.vendormangedinventory.controllers;

import org.launchcode.vendormangedinventory.models.Address;
import org.launchcode.vendormangedinventory.models.Warehouse;
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
import java.util.Map;

@Controller
@RequestMapping(value="warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseDao warehouseDao;

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
}
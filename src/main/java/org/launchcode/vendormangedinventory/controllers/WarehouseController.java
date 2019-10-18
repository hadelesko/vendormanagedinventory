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

import javax.validation.Valid;

@Controller
@RequestMapping(value="warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseDao warehouseDao;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createWarehouse(Model model) {
        model.addAttribute("tile", "Create new warehouse");
        model.addAttribute(new Warehouse());
        model.addAttribute(new Address());
        return "warehouse/add";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addWarehouse(Model model, @ModelAttribute @Valid Warehouse warehouse,
                               @ModelAttribute @Valid Address address,
                               Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add new Warehouse");
            return "warehouse/add";
        }
        warehouseDao.save(warehouse);
        return "warehouse/add";
    }
}
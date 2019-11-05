package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Product;
import org.launchcode.vendormangedinventory.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VendorDao extends CrudRepository<Vendor, Integer> {
    Vendor findById(int id);
    Vendor findByName(String name);
    List <Vendor>findByProduct(Product product);
}

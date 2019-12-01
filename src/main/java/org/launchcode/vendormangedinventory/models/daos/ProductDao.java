package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Product;
import org.launchcode.vendormangedinventory.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    Product findById(int id);
    List<Product>findByQuantityLessThan(int quantity);
}

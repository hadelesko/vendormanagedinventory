package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Customer_Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface Customer_ProductDao extends CrudRepository<Customer_Product, Long> {
}

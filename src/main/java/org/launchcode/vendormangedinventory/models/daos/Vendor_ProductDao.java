package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Transaction_Vendor_Product_to_or_from_Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface Vendor_ProductDao extends CrudRepository<Transaction_Vendor_Product_to_or_from_Warehouse, Integer> {
}

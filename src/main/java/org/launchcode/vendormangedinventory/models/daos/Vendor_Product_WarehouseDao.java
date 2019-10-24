package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Vendor_Product_Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface Vendor_Product_WarehouseDao extends CrudRepository<Vendor_Product_Warehouse,Integer> {
}

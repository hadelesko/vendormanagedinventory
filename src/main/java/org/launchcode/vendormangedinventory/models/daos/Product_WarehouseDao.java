package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Product_Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface Product_WarehouseDao extends CrudRepository<Product_Warehouse, Long> {
}

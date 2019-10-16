package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WarehouseDao extends CrudRepository<Warehouse, Integer> {
}

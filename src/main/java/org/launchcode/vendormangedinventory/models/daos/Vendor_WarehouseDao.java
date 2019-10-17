package org.launchcode.vendormangedinventory.models.daos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface Vendor_WarehouseDao extends CrudRepository<Vendor_WarehouseDao, Integer>{

}

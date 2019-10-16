package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VendorDao extends CrudRepository<Vendor, Integer> {
}

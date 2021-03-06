package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer>{
    Customer findById(int id);
}

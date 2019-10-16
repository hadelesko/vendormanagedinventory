package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DeliveryDao extends CrudRepository<Delivery, Integer> {
}

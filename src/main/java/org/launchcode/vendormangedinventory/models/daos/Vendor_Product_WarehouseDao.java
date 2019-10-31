package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.TransVendorProductWarehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface Vendor_Product_WarehouseDao extends CrudRepository<TransVendorProductWarehouse,Integer> {

    TransVendorProductWarehouse findById(int id);

    List<TransVendorProductWarehouse> findByVendorIdAndProductId(int vendorId, int productId);

    List<TransVendorProductWarehouse> findByVendorIdAndWarehouseId(int vendorId, int warehouseId);

    List<TransVendorProductWarehouse> findByProductIdAndWarehouseId(int productId, int warehouseId);

    //All transactions relative to the vendor_V for th product_X to or from the warehouse_W. This is useful for the warehouse
    // or the vendor to track transaction(reception/delivery, retour) for specific specific product
    List<TransVendorProductWarehouse> findByVendorIdAndProductIdAndWarehouseId(int vendorId, int productId, int warehouseId);

    List<TransVendorProductWarehouse> findByTransactionsDate(Date transactionsDate);

    List<TransVendorProductWarehouse> findByVendorId(int vendorId);
    List<TransVendorProductWarehouse> findByProductId(int productId);
    List<TransVendorProductWarehouse> findByWarehouseId(int warehouseId);

}

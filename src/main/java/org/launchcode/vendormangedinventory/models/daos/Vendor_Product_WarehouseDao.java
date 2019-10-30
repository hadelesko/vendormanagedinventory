package org.launchcode.vendormangedinventory.models.daos;

import org.launchcode.vendormangedinventory.models.Transaction_Vendor_Product_to_or_from_Warehouse;
import org.launchcode.vendormangedinventory.models.Vendor_Product_Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface Vendor_Product_WarehouseDao extends CrudRepository<Transaction_Vendor_Product_to_or_from_Warehouse,Integer> {

    Transaction_Vendor_Product_to_or_from_Warehouse findById(int transactionId);

    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByVendor_idAndProductId(int vendor_id, int product_id);

    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByVendor_idAndFrom_or_to_warehouse_id(int vendor_id, int warehouse_id);

    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByProduct_idAndFrom_or_to_warehouse_id(int product_id, int warehouse_id);

    //All transactions relative to the vendor_V for th product_X to or from the warehouse_W. This is useful for the warehouse
    // or the vendor to track transaction(reception/delivery, retour) for specific specific product
    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByVendor_idAndProduct_idAndFrom_or_to_warehouse_id(int vendor_id, int product_id, int warehouse_id);

    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByTransactionsDate(Date transactionsDate);

    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByVendor_id(int vendor_id);
    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByProduct_id(int product_id);
    List<Transaction_Vendor_Product_to_or_from_Warehouse> findByFrom_or_to_warehouse_id(int from_or_to_warehouse_id);

    /*   private int id;
    private int vendor_id;
    private int product_id;
    private Date transactionsDate;
    private int quantity;
    private String description;
    private int from_or_to_warehouse_id*/

}


package org.launchcode.vendormangedinventory.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Entity
public class Vendor_Warehouse {
    /*This class is designed to record the flow of material between
     vendor(deliver product) and warehouse(reception and retour)==>
     Journal of the flows
    * */
    @Id
    @GeneratedValue
    private int id;

    private int vendorId;
    private int warehouseId;
    private int quantity;
    private Date date;

    public Vendor_Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

/*    @ManyToOne
    private Product product;
    @NotNull
    private int quantity_delivered;*//*


*/
/*    @OneToMany
    private Warehouse destinationWarehouse;*//*


    public Vendor_Warehouse (){}

}
*/

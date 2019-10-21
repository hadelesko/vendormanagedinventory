
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

    private long vendor_id;
    private long warehouse_id;
    private int quantity;
    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(long vendor_id) {
        this.vendor_id = vendor_id;
    }

    public long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(long warehouse_id) {
        this.warehouse_id = warehouse_id;
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

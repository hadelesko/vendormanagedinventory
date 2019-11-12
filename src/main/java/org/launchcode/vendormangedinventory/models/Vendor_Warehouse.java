
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

    private int vendor_id;
    private int warehouse_id;
    private int quantity;
    private String description;
    private Date date;

    public Vendor_Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
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

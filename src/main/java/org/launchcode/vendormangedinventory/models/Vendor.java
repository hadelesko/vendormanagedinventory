package org.launchcode.vendormangedinventory.models;

///import com.sun.imageio.plugins.jpeg.JPEG;



import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/*import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;*/



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendor")
@Access(value= AccessType.FIELD)
public class Vendor {
    @Id
    @GeneratedValue
    private int id;
    //@NotBlank
    //@Length(min=5, max=40, message="At least 5 and maximum 40 characters")
    private String name;
    @Embedded
    private Address address;
/*    @Lob
    @Basic(fetch = FetchType.LAZY)
    private JPEG picture;*/

  @ManyToOne(cascade = CascadeType.ALL)
           //@JoinColumn(name = "product_id") //we write product in the column product-id of th table vendor
  private Product product;

    /*One vendor can deliver or store product in one or more warehouses
    *  mappedBy="deliveries" to refer to the join table delivery in the warehouse entity
    *
    * */

   /* @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="vendor_warehouse",
        joinColumns = {@JoinColumn(name="vendor_id")},
        inverseJoinColumns = {@JoinColumn(name="warehouse_id")})*/
    @ManyToMany
    private Set<Warehouse> warehouseList =new HashSet<>();

    public Vendor(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(Set<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

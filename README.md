### Overview
<h1><a href="https://github.com/hadelesko/vendormanagedinventory">Vendor Managed Inventory</a></h1>
<p style="text-align:justify">The vendors are associated to a warehouse and keep track on the inventory of the products/items in the warehouse and update the stock as soon as needed. In this case every Vendor or supplier has his specific sets of products in the warehouse and is responsible for its inventories. The vendor is not present in the warehouse but keep track on his products sold in this warehouse and reacts to deliver as soon as the stock is low.</p>
<p><h3>Why this project?</h3></p>
<p style="text-align:justify">The management of the inventories in some warehouse  requires large technical assistance and human resources. All this increase the management cost. Another problem is the availability for the information related to the existing stock of the material to the suppliers so that they can optimize  their  production plan and deliver optimal quantity of their products in the warehouse on the time. The basis of the decision is the information. To make this information permanently ready for the decision for each partner of the warehouse we'll design a system to let the Vendors or Suppliers to follow the usage or the sale of the supplied products so that they can react properly to refill the stock of the product accordingly to the needs in the warehouse.This system  can be designed as following:</p>
 
<p style="text-align=:justify">The warehouse  generally works together with  the supplier(Vendors who deliver the products/items), the production or customer(who buys its products or consume the products). We can then identify four principals entities:</p>
<ul>
<li>Vendor or Supplier: defined as the external partner of the warehouse increase the stored products quantity in the warehouse by delivering products.</li>
<li>Warehouse or Market or storage: defined as the hub or the place where product are available for sale to the customer. It interacts with the suppliers(send products, deliver products) and customers(buy, receive products, pay bill  for the bought products)</li>
<li>Product or Item: The counterpart of the transactions between the warehouse and customer, the vendor and warehouse.</li>
<li>Production or Customer  : The production can decrease the amount of the stored material buy using it in the production process. The customer decreases the quantity of the product in the warehouse by buying it. customer is external partner to the warehouse like supplier. </li></ul>

<p>The interaction described between the four entities above lead to entities relationship that  we can see <a href="https://github.com/hadelesko/vendormanagedinventory/blob/master/src/main/resources/static/Screenshot%20from%202019-10-17%2020-57-55.png">here</a></p>
<h3>Features</h3>
<p>As described above this application will support the warhouse, the Vendors and customer in their inteactions. All together we can identify the following methods:</p>
<ul>
<li><strong>Add: </strong> new customer, new vendor, new product</li>
<li><strong>Login: </strong> vendor, customer</li>
<li><strong>Receive: </strong> a product from vendors or from customer after return</li>
<li><strong>Return: </strong> product: warehouse retun product to the vendor</li>
<li><strong>Search: </strong> product, customer, vendor</li>
</ul>

<h3>Technologies</h3>
In this project will use some technologies for the back-end(Java, springboot, mysql) and front-end(Thymeleaf, Bootstrap, Javascript)
<ul><li>Java</li>
<li>SpringBoot</li>
<li>Mysql</li>
<li>Thymeleaf</li>
<li>Bootstrap</li>
<li>Javascript</li>
</ul>
<h3>What I'll Have to Learn</h3>
For some statistic purposes I will learn <a href="https://d3js.org/" target="_blank">D3.js</a><br/>
<h3>Project Tracker</h3>
As described in the overview feature and technologie, the progress in this project can be followed <a href="https://trello.com/b/rtJ90o14/welcome-to-trello">here</a> 

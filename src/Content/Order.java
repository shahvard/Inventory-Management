
package Content;

public class Order {
    
    private String orderID;
    private String customerID;
    private String product;
    private String shipmethod;
    
    public Order(String orderID){
        this.orderID = orderID;
    }

    
    public String getOrderID() {
        return orderID;
    }
    
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    
    public String getCustomerID() {
        return customerID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    
    public String getShipmethod() {
        return shipmethod;
    }

    public void setShipmethod(String shipmethod) {
        this.shipmethod = shipmethod;
    }
    
}

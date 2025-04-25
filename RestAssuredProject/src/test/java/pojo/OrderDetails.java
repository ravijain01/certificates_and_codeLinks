package pojo;

public class OrderDetails {
    String country;
    String productOrderId;
    public String getCountry(){
        return country;
    }
    public void setCountry(String country)
    {
        this.country=country;
    }
    public String getProductOrderedId(){
        return productOrderId;
    }
    public void setProductOrderId(String productOrderedId)
    {
        this.productOrderId=productOrderedId;
    }
}

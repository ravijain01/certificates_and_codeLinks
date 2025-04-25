package demo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetails;
import pojo.Orders;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ECommerceAPITest {
    public static  void main(String [] args)
    {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("ravigang@gmail.com");
        loginRequest.setUserPassword("Ravi@123");

        LoginResponse loginResponse = given()
                .baseUri("https://rahulshettyacademy.com")
                .contentType(ContentType.JSON)
                .body(loginRequest)
//                .log().all()
                .when()
                .post("/api/ecom/auth/login")
                .then()
                .log().all()
                .extract()
                .response()
                .as(LoginResponse.class);

        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUserId());
        String token=loginResponse.getToken();
        String userId=loginResponse.getUserId();

        //Add product----------------->
        Response response=given()
                .baseUri("https://rahulshettyacademy.com")
                .header("Authorization", token)
//                .log().all()
                .param("productName", "Laptop")
                .param("productAddedBy", userId)
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts")
                .param("productPrice", "15000")
                .param("productDescription", "Lenova")
                .param("productFor", "men")
                .multiPart("productImage", new File("C:\\Users\\ravi.jain.in\\Downloads\\still-life-spring-wardrobe-switch (1).jpg"))
                .when()
                .post("/api/ecom/product/add-product");

        // Extract productId from the response
        JsonPath js = new JsonPath(response.asString());
        String productId = js.get("productId");
        System.out.println(productId);

        //Create Order ------------------>
        OrderDetails orderDetail=new OrderDetails();
        orderDetail.setCountry("India");
        orderDetail.setProductOrderId(productId);
        List<OrderDetails> orderDetailList=new ArrayList<OrderDetails>();
        orderDetailList.add(orderDetail);
        Orders orders=new Orders();
        orders.setOrders(orderDetailList);

        Response response1 =given()
                .baseUri("https://rahulshettyacademy.com")
                .header("authorization", token)
                .contentType(ContentType.JSON)
//                .log().all()
                .body(orders).when()
                .post("/api/ecom/order/create-order");

        System.out.println(response1.asString());

        // Delete the product

        Response response2=given().baseUri("https://rahulshettyacademy.com").header("authorization",token)
                .contentType(ContentType.JSON).log().all().pathParam("productId",productId)
                .when().delete("/api/ecom/product/delete-product/{productId}");
        System.out.println(response2.asString());
        JsonPath js2=new JsonPath(response2.asString());
        Assert.assertEquals(js2.get("message"),"Product Deleted Successfully");
    }
}

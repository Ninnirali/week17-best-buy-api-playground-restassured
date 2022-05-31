package ui.swagger.products;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.ProductPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ProductPostTest extends TestBase {

    @Test
    public void createAProduct() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("name");
        productPojo.setType("type");
        productPojo.setPrice(22.22);
        productPojo.setShipping(1);
        productPojo.setUpc("078592233");
        productPojo.setDescription("description ");
        productPojo.setManufacturer("manufacturer");
        productPojo.setModel("ABCD01234");
        productPojo.setUrl("http://ABC");
        productPojo.setImage("JPEG");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();

    }
}

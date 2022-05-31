package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.StorePojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class StorePatchTest extends TestBase {

    @Test
    public void updateAStoreBasedOnStoreId(){

        StorePojo storePojo = new StorePojo();
        storePojo.setName("happy");
        storePojo.setAddress("butterfly lane");
        storePojo.setLng(4444);
        storePojo.setLat(2222);

       Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id",10)
                .body(storePojo)
                .when()
                .patch("/stores/{id}");
                response.then().statusCode(200);
                response.prettyPrint();
    }
}

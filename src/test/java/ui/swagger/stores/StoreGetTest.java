package ui.swagger.stores;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StoreGetTest extends TestBase {

    @Test
    public void getAllStoreInfo() {

        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .when()
                .get("/stores");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
    @Test
    public void getSingleStoreInfo() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .pathParam("id",10)
                .when()
                .get("/stores/{id}");
       response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }

}

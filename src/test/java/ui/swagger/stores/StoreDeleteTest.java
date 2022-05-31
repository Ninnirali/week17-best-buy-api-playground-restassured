package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class StoreDeleteTest extends TestBase {

    @Test
    public void deleteStore(){
       Response response = given()
                .header("Authorization","Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
               .header("Accept","application/json")
                .pathParam("id",8)
                .when()
                .delete("/stores/{id}");
               response.then().statusCode(200);
                response.prettyPrint();
    }
}

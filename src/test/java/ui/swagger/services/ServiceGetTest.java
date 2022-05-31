package ui.swagger.services;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ServiceGetTest extends TestBase {

    @Test
    public void getAllServicesInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }

    @Test
    public void getASingleServiceInfo() {
        Response response = given()
                .pathParam("id",8)
                .when()
                .get("/services/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }

}

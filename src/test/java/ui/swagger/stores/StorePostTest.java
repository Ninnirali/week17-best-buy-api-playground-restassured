package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.StorePojo;
import ui.swagger.testbase.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class StorePostTest extends TestBase {

    @Test
    public void createANewStore() {

        HashMap<Object, Object> services = new HashMap<>();
        services.put("id", "9");
        services.put("name", "Geek Squad Services");
        services.put("createdAt", "2016-11-17T17:56:35.881Z");
        services.put("updatedAt", "2016-11-17T17:56:35.881Z");

        StorePojo storePojo = new StorePojo();
        storePojo.setName("happy1");
        storePojo.setType("bunny");
        storePojo.setAddress("123");
        storePojo.setAddress2("456");
        storePojo.setCity("abc");
        storePojo.setState("xyz");
        storePojo.setZip("1111");
        storePojo.setLat(1234);
        storePojo.setLng(5678);
        storePojo.setHours("11");
        storePojo.setServices(services);

        Response response = given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}

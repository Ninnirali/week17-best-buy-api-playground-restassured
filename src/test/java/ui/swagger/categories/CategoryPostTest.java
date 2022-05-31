package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.CategoriesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CategoryPostTest extends TestBase {

    @Test
    public void createACategory() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setName("name123");
        categoriesPojo.setId("44");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}

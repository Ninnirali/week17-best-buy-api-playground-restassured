package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.CategoriesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CategoryPatchTest extends TestBase {
    @Test
    public void modifySingleCategoryInfo() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Abc");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "abcat0010000")
                .when()
                .patch("/categories/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(3000L));
        response.prettyPrint();
    }
}

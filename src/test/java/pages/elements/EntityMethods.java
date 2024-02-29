package pages.elements;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pogo.AllEntitiesResponse;
import pogo.Entity;
import tests.api.tests.SetupTest;

import static io.restassured.RestAssured.given;

public class EntityMethods extends SetupTest {
    @Step("Send POST request to /api/create and check statusCode")
    public String createNewEntity(Entity entity) {
        return given()
                .body(entity)
                .when()
                .post("/create")
                .then()
                .statusCode(200)
                .extract().body().asString();

    }

    @Step("Send DELETE request to /api/delete/{id} and check statusCode")
    public String deleteEntityById(String entityId) {
        return given()
                .when()
                .delete("/delete/" + entityId)
                .then()
                .statusCode(204)
                .extract().body().asString();
    }

    @Step("Send GET request to /api/get/{id} and check statusCode")
    public ValidatableResponse getEntityById(String entityId) {
        return given()
                .when()
                .get("/get/" + entityId)
                .then()
                .statusCode(200);
    }

    @Step("Send PATCH request to /api/patch/{id} and check statusCode")
    public String updateEntityById(Entity newEntity, String entityId) {
        return given()
                .body(newEntity)
                .when()
                .patch("/patch/" + entityId)
                .then()
                .statusCode(204)
                .extract().asString();
    }
    @Step("Send GET request to /api/getAll without parameters and check statusCode")
    public AllEntitiesResponse getAllEntitiesWithoutParams() {
        return given()
                .when()
                .get("/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(AllEntitiesResponse.class);

    }
    @Step("Send GET request to /api/getAll with parameters and check statusCode")

    public AllEntitiesResponse getAllEntitiesWithParams(String title, boolean verified, int page, int perPage) {
        return given()
                .queryParams("title", title, "verified", verified, "page", page, "perPage", perPage)
                .when()
                .get("/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(AllEntitiesResponse.class);

    }
}

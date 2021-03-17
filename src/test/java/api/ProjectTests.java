package test.java.api;

import org.testng.annotations.Test;
import test.java.helpers.PropertyLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProjectTests extends BaseApiTest{

    private final String ENTITY = "/projects";
    private String createdProjectId;

    @Test
    public void getProjectById() {
        given()
                .header("Authorization", "Bearer " + this.TOKEN)
        .when()
                .get(PropertyLoader.getProperty("api.url") + ENTITY + "/2237619831")
        .then()
            .statusCode(200)
            .assertThat()
            .body(matchesJsonSchemaInClasspath("projectByID.json"));
            //.extract()
            //.path("url");
    }

    @Test
    public void postProject() {
        createdProjectId = (String) given()
                .header("Authorization", "Bearer " + this.TOKEN)
                .header("X-Request-Id", "123213243245331")
                .contentType("application/json")
                .body("{\"name\": \"Shopping List\"}")
        .when()
                .post(PropertyLoader.getProperty("api.url") + ENTITY)
        .then()
                .statusCode(200).extract().path("id");
    }

    @Test(dependsOnMethods = "postProject")
    public void deleteProject() {
        given()
                .header("Authorization", "Bearer " + this.TOKEN)
        .when()
                .delete(PropertyLoader.getProperty("api.url") + ENTITY + "/" + createdProjectId)
        .then()
                .statusCode(204);
    }
}

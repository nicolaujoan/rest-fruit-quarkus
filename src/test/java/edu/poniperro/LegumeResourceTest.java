package edu.poniperro;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LegumeResourceTest {
    
    @Test
    public void testGetList() {
        given()
        .when().get("/legumes")
        .then()
            .statusCode(200)
            .body("$.size()", is(2),
            "[0].name", is("Carrot"),
                        "[0].description", is("Root vegetable, usually orange"),
                        "[1].name", is("Zucchini"),
                        "[1].description", is("Summer squash"));
    }
}

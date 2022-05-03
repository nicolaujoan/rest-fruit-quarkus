package edu.poniperro;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.*;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FruitResourceTest {
    
    @Test
    public void testList() {
        given()
        .when().get("/fruits")
        .then()
            .statusCode(200)
            .body("$.size()", is(2),
            "[0].name", is("Apple"),
                        "[0].description", is("Winter fruit"),
                        "[1].name", is("Mango"),
                        "[1].description", is("Tropical fruit"));
    }

    @Test
    public void testPostFruit() {
        given()
                .contentType("application/json")
                .body(new Fruit("Mandarina", "Mediterranian fruit"))
                .when()
                .post("/fruits")
                .then()
                .statusCode(201)
                .body("$.size()", is(3),
                    "[0].name", is("Apple"),
                                "[0].description", is("Winter fruit"),
                                "[1].name", is("Mango"),
                                "[1].description", is("Tropical fruit"),
                                "[2].name", is("Mandarina"),
                                "[2].description", is("Mediterranian fruit"));
    }

    @Test
    public void testDeleteFruit() {
        given()
                .contentType("application/json")
                .body(new Fruit("Mango", "Tropical fruit"))
                .when()
                .delete("/fruits")
                .then()
                .statusCode(202)
                .body("$.size()", is(1),
                    "[0].name", is("Apple"),
                                "[0].description", is("Winter fruit"))
                .and().assertThat();
    }
}

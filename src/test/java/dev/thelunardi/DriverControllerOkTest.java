package dev.thelunardi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class DriverControllerOkTest {
    @Test
    public void testListDriversEndpointOK() {
        given()
          .when().get("/f1/drivers")
          .then()
             .statusCode(200);
    }

    @Test
    public void testListCircuitsEndpointOK() {
        given()
                .when().get("/f1/circuits")
                .then()
                .statusCode(200);
    }
}
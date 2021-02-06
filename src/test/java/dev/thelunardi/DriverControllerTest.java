package dev.thelunardi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DriverControllerTest {

    @Test
    public void testListDriversEndpoint() {
        given()
          .when().get("/f1/drivers")
          .then()
             .statusCode(200);
    }
}
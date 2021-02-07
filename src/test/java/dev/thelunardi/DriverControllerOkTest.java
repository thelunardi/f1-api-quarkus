package dev.thelunardi;

import dev.thelunardi.exception.DriverException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.utils.DriverClientBuilder;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.net.MalformedURLException;

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
}
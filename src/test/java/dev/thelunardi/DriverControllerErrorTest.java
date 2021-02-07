package dev.thelunardi;

import dev.thelunardi.exception.DriverException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.service.DriverService;
import dev.thelunardi.utils.DriverClientBuilder;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import java.net.MalformedURLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DriverControllerErrorTest {
    @InjectMock
    DriverClientBuilder driverClientBuilder;

    @Inject
    ConstantHelper constantHelper;

    @Test
    public void testListDriversEndpointBadRequest() throws MalformedURLException {
        Mockito.when(driverClientBuilder.build(constantHelper.getF1Url())).thenThrow(DriverException.class);

        given()
                .when().get("/f1/drivers")
                .then()
                .statusCode(400);
    }

    @Test
    public void testListDriversEndpointError() throws Exception {
        Mockito.when(driverClientBuilder.build(constantHelper.getF1Url())).thenThrow(RuntimeException.class);

        given()
                .when().get("/f1/drivers")
                .then()
                .statusCode(500);
    }
}
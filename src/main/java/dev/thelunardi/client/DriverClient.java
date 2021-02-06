package dev.thelunardi.client;

import dev.thelunardi.model.DriverResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
@RegisterProvider(value = DriverRequestMapper.class)
@Path("api/f1")
public interface DriverClient {
    @GET
    @Path("/drivers.json")
    @Produces(MediaType.APPLICATION_JSON)
    DriverResponse getDrivers();
}

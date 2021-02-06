package dev.thelunardi.controller;

import dev.thelunardi.model.Driver;
import dev.thelunardi.service.DriverService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/f1")
public class DriverController {
    @Inject
    DriverService driverService;

    @GET
    @Path("drivers")
    public List<Driver> getDrivers(String id) throws Exception {
        return driverService.getDrivers();
    }
}
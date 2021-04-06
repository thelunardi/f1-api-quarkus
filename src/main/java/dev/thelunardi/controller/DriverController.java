package dev.thelunardi.controller;

import dev.thelunardi.exception.DriverException;
import dev.thelunardi.service.DriverService;
import dev.thelunardi.service.DriverServiceImpl;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;

@Path("/f1")
public class DriverController {
    private static final Logger LOG = Logger.getLogger(DriverServiceImpl.class);

    @Inject
    DriverService driverService;

    @GET
    @Path("drivers")
    public Response getDrivers(String id) throws Exception {
        try {
            return Response.ok(driverService.getDrivers()).build();
        } catch (MalformedURLException | DriverException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os pilotos", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("internal/drivers/{id}")
    public Response getDriverById(@PathParam("id") String id) throws Exception {
        try {
            return Response.ok(driverService.getInternalDriverById(id)).build();
        } catch (MalformedURLException | DriverException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os pilotos", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
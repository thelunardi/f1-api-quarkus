package dev.thelunardi.controller;

import dev.thelunardi.exception.CircuitException;
import dev.thelunardi.service.CircuitService;
import dev.thelunardi.service.DriverServiceImpl;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;

@Path("/f1")
public class CircuitController {
    private static final Logger LOG = Logger.getLogger(DriverServiceImpl.class);

    @Inject
    CircuitService circuitService;

    @GET
    @Path("circuits")
    public Response getCircuits(String id) throws Exception {
        try {
            return Response.ok(circuitService.getCircuits()).build();
        } catch (MalformedURLException | CircuitException e) {
            LOG.errorf("Erro ao listar os circuitos", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os circuitos", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
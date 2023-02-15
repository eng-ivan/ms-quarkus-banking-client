package core.ics.controller;

import core.ics.model.Client;
import core.ics.model.ConnectionTest;
import core.ics.repository.ClientRepository;
import core.ics.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Date;

@Slf4j
@ApplicationScoped
@Path(value = "/api")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    ClientService clientService;

    @POST
    @Path(value = "/client/save")
    @Transactional
    public Response saveClient(Client client){
        log.info("Client Saved {}", client);
        Client clientSaved = clientService.save(client);
        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("/api/client/save"))
                .entity(clientSaved)
                .build();
    }

    @GET
    @Path(value = "/client/list")
    public Response list(){

        return Response
                .status(Response.Status.OK)
                .entity(clientService.list())
                .location(URI.create("/api/client/list"))
                .build();
    }

    @GET
    @Path(value = "/connection-test")
    public Response connectionTest() throws UnknownHostException {

        return Response
                .status(Response.Status.OK)
                .entity(ConnectionTest.test())
                .location(URI.create("/api/connection-test"))
                .build();
    }
}

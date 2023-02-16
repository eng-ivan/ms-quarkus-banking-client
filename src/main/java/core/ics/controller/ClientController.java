package core.ics.controller;

import core.ics.dto.ClientDTO;
import core.ics.model.Address;
import core.ics.model.Client;
import core.ics.model.ConnectionTest;
import core.ics.service.ClientService;
import core.ics.utils.AddressRequest;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.UnknownHostException;

@Slf4j
@ApplicationScoped
@Path(value = "/api")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    ClientService clientService;

    @Inject
    @RestClient
    AddressRequest request;

    @POST
    @Path(value = "/client/save")
    @Transactional
    public Response saveClient(Client client){
        log.info("Client Saved {}", client);

        Address address = request.requestAddress(client.getAddress());
        Client clientSaved = clientService.save(client);
        ClientDTO dto = new ClientDTO(clientSaved);
        dto.setAddress(address);

        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("/api/client/save"))
                .entity(dto)
                .build();
    }

    @GET
    @Path(value = "/client/{id}")
    public Response findByID(@PathParam("id") Long id){
        log.info("fetch ID {}", id);

        return Response
                .status(Response.Status.OK)
                .entity(clientService.findByID(id))
                .location(URI.create("/api/client/id"))
                .build();
    }

    @GET
    @Path(value = "/client/list")
    public Response list(){
        log.info("fetch list {}", clientService.list());

        return Response
                .status(Response.Status.OK)
                .entity(clientService.list())
                .location(URI.create("/api/client/list"))
                .build();
    }

    @GET
    @Path(value = "/connection-test")
    public Response connectionTest() throws UnknownHostException {
        log.info("Connection Test {}", ConnectionTest.test().toString());
        return Response
                .status(Response.Status.OK)
                .entity(ConnectionTest.test())
                .location(URI.create("/api/connection-test"))
                .build();
    }
}

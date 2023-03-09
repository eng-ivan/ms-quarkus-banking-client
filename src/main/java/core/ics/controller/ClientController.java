package core.ics.controller;

import core.ics.dto.ClientDTO;
import core.ics.model.*;
import core.ics.service.ClientService;
import core.ics.utils.AccountRequest;
import core.ics.utils.AddressRequest;
import core.ics.utils.CardRequest;
import core.ics.utils.ConnectionTestRequest;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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

    @Inject
    @Channel("topico")
    Emitter<Client> clientEmitter;

    @Inject
    @RestClient
    AddressRequest addressRequest;

    @Inject
    @RestClient
    AccountRequest accountRequest;

    @Inject
    @RestClient
    CardRequest cardRequest;

    @Inject
    @RestClient
    ConnectionTestRequest connectionTestRequest;


    @POST
    @Path(value = "/client/save")
    @Transactional
    public Response saveClient(Client client){
        log.info("Client Saved {}", client);
        log.info("Client ID {}", client.getId());
        Address address = addressRequest.requestAddress(client.getAddress());
        Account account = accountRequest.account();
        Card card = cardRequest.card();

        Client clientSaved = clientService.save(client);

        clientEmitter.send(clientSaved);

        ClientDTO dto = new ClientDTO(clientSaved);
        dto.setAddress(address);
        dto.setAccount(account);
        dto.setCard(card);
        dto.getCard().setCardHolder(client.getName());

        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("/api/client/save"))
                .entity(dto)
                .build();
    }

    @GET
    @Path(value = "/client/{id}")
    public Response findByID(@PathParam("id") String id){
        log.info("fetch ID {}", id);

        return Response
                .status(Response.Status.OK)
                .entity(clientService.findByID(id))
                .location(URI.create("/api/client/id"))
                .build();
    }

    @GET
    @Path(value = "/client/full-data/{id}")
    public Response findFullDataClient(@PathParam("id") String id){
        log.info("fetch full data client ID {}", id);

        return Response
                .status(Response.Status.OK)
                .entity(clientService.findClientFullData(id))
                .location(URI.create("/api/client/full-data/id"))
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
    @Path(value = "/client")
    public Response findName(@QueryParam("name") String name){
        log.info("fetch by name {}", clientService.findByName(name));

        return Response
                .status(Response.Status.OK)
                .entity(clientService.findByName(name))
                .location(URI.create("/api/client"))
                .build();
    }

    @GET
    @Path(value = "/test")
    public Response connectionTest() throws UnknownHostException {
        log.info("Connection Test ");
        ConnectionTest test = ConnectionTest
                .builder()
                .address(InetAddress.getLocalHost())
                .createAt(new Date().toString())
                .build();

        return Response
                .status(Response.Status.OK)
                .entity(test)
                .location(URI.create("/api/test"))
                .build();
    }
}

package core.ics.utils;

import core.ics.model.Account;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8082/api")
public interface AccountRequest {

    @POST
    @Path(value = "/account/save")
    Account account();

    @GET
    @Path(value = "/account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Account findAccountByID(@PathParam("id") String id);
}

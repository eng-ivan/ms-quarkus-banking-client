package core.ics.utils;

import core.ics.model.Card;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8083/api")
public interface CardRequest {

    @POST
    @Path(value = "/card/save")
    Card card();

    @GET
    @Path(value = "/card/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Card findCardByID(@PathParam("id") String id);
}

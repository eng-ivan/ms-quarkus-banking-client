package core.ics.utils;

import core.ics.model.ConnectionTest;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RegisterRestClient(baseUri = "http://localhost:8085/api")
public interface ConnectionTestRequest {

    @GET
    @Path(value = "/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    ConnectionTest test();
}

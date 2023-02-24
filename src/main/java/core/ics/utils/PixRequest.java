package core.ics.utils;

import core.ics.model.Pix;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8084/api")
public interface PixRequest {

    @GET
    @Path(value = "/pix/find/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Pix pix(@PathParam("key") String key);
}

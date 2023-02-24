package core.ics.utils;

import core.ics.model.Card;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8083/api")
public interface CardRequest {

    @POST
    @Path(value = "/card/save")
    Card card();
}

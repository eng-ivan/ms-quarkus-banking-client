package core.ics.utils;

import core.ics.model.Account;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://localhost:8082/api")
public interface AccountRequest {

    @POST
    @Path(value = "/account/save")
    Account account();
}

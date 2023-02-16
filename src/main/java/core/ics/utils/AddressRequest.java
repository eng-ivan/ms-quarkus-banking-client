package core.ics.utils;
import core.ics.model.Address;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://viacep.com.br/ws")
public interface AddressRequest {

    @GET
    @Path("/{cep}/json/")
    @Produces(MediaType.APPLICATION_JSON)
    Address requestAddress(@PathParam("cep") String cep);
}

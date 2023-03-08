package core.ics.exceptions;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientHandlerException implements ExceptionMapper<RuntimeException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(RuntimeException exception) {

        MessageError me = new MessageError();
        if(exception instanceof BusinessException){
            me.setMessage(exception.getMessage());
            return Response.status(Response.Status.NOT_FOUND).entity(me).build();
        }

        me.setMessage(exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(me).build();
    }
}

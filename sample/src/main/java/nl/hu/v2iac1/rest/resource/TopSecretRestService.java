package nl.hu.v2iac1.rest.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.v2iac1.Configuration;

@Path("/topsecret")
@Produces(MediaType.TEXT_PLAIN)
public class TopSecretRestService extends AbstractRestService {

    @POST
    @Path("/")
    public Response getSecret() {

        String output = "This is TOP secret: " + configuration.getValue(Configuration.Key.TOPSECRET);
        return Response.status(200).entity(output).build();

    }

}
package fr.fxjavadevblog.qjg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/api/ping")
public class PingService
{
    @Path("/v1")
    @GET
    @Produces("text/plain")
    public String ping()
    {
        return "Pong";
    }
}

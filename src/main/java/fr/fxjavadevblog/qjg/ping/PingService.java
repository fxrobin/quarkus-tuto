package fr.fxjavadevblog.qjg.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Simple JAX-WS endoint to check if the application is running.
 * 
 * @author robin
 *
 */

@Path("/api/ping")
public class PingService
{
    @Path("/v1")
    @GET
    @Produces("text/plain")
    public String ping()
    {
        return "pong";
    }
}

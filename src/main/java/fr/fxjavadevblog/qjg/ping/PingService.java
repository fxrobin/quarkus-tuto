package fr.fxjavadevblog.qjg.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * Simple JAX-WS endoint to check if the application is running.
 * 
 * @author robin
 *
 */

@Path("/api/ping/v1")
public class PingService
{
    @Operation(summary = "Get pong", description = "returns a simple reponse as ping/pong ")
    @GET
    @Produces("text/plain")
    public String ping()
    {
        return "pong";
    }
}

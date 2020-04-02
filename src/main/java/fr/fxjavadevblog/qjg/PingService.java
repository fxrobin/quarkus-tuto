package fr.fxjavadevblog.qjg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import lombok.Getter;

@Path("/api/ping")
public class PingService
{
    
    @Getter
    private String hello = "Hello";
    
    @Path("/v1")
    @GET
    @Produces("application/json")
    public String ping()
    {
        return "PONG" + this.getHello();
    }
}

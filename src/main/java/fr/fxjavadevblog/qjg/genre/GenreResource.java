package fr.fxjavadevblog.qjg.genre;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * JAX-WS endpoint for Video Games.
 * 
 * @author robin
 *
 */

@Path("/api/genres/v1")
public class GenreResource
{  
    @Operation(summary = "returns all genres of video games on Atari ST")
    @GET
    @Produces("application/json")
    public Genre[] getAllGenres()
    {
        return Genre.values();
    }   
}

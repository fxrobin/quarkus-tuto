package fr.fxjavadevblog.qjg.genre;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * JAX-RS endpoint for genre of video games.
 * 
 * @author robin
 *
 */

@Path("/api/genres/v1")
@Produces("application/json")
public class GenreResource
{  
    @GET
    @Operation(summary = "returns all genres of video games on Atari ST")
    public Genre[] getAllGenres()
    {
        return Genre.values();
    }   
}

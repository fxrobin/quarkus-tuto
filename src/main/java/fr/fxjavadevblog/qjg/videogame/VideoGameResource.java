package fr.fxjavadevblog.qjg.videogame;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

import fr.fxjavadevblog.qjg.genre.Genre;

/**
 * JAX-RS endpoint for Video Games.
 * 
 * @author robin
 *
 */
@Path("/api/videogames/v1")
@Produces("application/json")
public class VideoGameResource
{
    @Inject
    VideoGameRepository videoGameRepository;
    
    @GET
    @Operation(summary = "Get games", description = "Get all video games on Atari ST")
    public Iterable<VideoGame> findAll()
    {
        return videoGameRepository.findAll();
    }
 
    @GET
    @Operation(summary = "Get games within a genre", description = "Get all video games of the given genre")
    @Path("/genre/{genre}")
    public List<VideoGame> findByGenre(@PathParam("genre") Genre genre)
    {
        return videoGameRepository.findByGenre(genre);
    }
}

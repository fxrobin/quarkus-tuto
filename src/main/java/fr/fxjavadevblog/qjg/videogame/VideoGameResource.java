package fr.fxjavadevblog.qjg.videogame;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

import fr.fxjavadevblog.qjg.genre.Genre;

/**
 * JAX-WS endpoint for Video Games.
 * 
 * @author robin
 *
 */
@Path("/api/videogames/v1")
public class VideoGameResource
{
    private final VideoGameRepository videoGameRepository;

    public VideoGameResource(VideoGameRepository videoGameRepository)
    {
        this.videoGameRepository = videoGameRepository;
    }

    @Operation(summary = "Get games", description = "Get all video games on Atari ST")
    @GET
    @Produces("application/json")
    public Iterable<VideoGame> findAll()
    {
        return videoGameRepository.findAll();
    }

    @Operation(summary = "Get games within a genre", description = "Get all video games of the given genre")
    @GET
    @Path("/genre/{genre}")
    @Produces("application/json")
    public List<VideoGame> findByGenre(@PathParam(value = "genre") Genre genre)
    {
        return videoGameRepository.findByGenre(genre);
    }
}

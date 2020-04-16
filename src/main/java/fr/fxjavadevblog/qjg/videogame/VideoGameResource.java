package fr.fxjavadevblog.qjg.videogame;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.fxjavadevblog.qjg.genre.Genre;

/**
 * JAX-RS endpoint for Video Games.
 * 
 * @author François-Xavier Robin
 *
 */
@Path("/api/videogames/v1")
@Produces("application/json")
public class VideoGameResource
{
    private static final Logger log = LoggerFactory.getLogger(VideoGameResource.class);
    
    @Inject
    VideoGameRepository videoGameRepository;

    @GET
    @Operation(summary = "Get games", description = "Get all video games on Atari ST")
    @Timed(name = "videogames-find-all", absolute = true, description = "A measure of how long it takes to fetch all video games.", unit = MetricUnits.MILLISECONDS)
    public Iterable<VideoGame> findAll()
    {
        return videoGameRepository.findAll();
    }

    @GET
    @Operation(summary = "Get games within a genre", description = "Get all video games of the given genre")
    @Path("/genre/{genre}")
    @Timed(name = "videogames-find-by-genre", absolute = true, description = "A measure of how long it takes to fetch all video games filtered by a given genre.", unit = MetricUnits.MILLISECONDS)
    public List<VideoGame> findByGenre(@PathParam("genre") Genre genre)
    {
        log.debug("Calling {}.findByGenre : {}", this.getClass().getSimpleName(), genre);
        return videoGameRepository.findByGenre(genre);
    }
}

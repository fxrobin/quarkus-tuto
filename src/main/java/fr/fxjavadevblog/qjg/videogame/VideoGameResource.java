package fr.fxjavadevblog.qjg.videogame;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

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

    @GET
    @Produces("application/json")
    public Iterable<VideoGame> findAll()
    {
        return videoGameRepository.findAll();
    }

    @GET
    @Path("/genre/{genre}")
    @Produces("application/json")
    public List<VideoGame> findByGenre(@PathParam(value = "genre") String genre)
    {
        try
        {
            Genre realGenre = Genre.valueOf(StringUtils.replace(genre, "-", "_").toUpperCase());
            return videoGameRepository.findByGenre(realGenre);
        }
        catch (java.lang.IllegalArgumentException e)
        {
            throw new BadRequestException("Genre " + genre + "does not exist.");
        }
    }
}

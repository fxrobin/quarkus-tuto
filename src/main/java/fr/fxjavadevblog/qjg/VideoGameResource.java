package fr.fxjavadevblog.qjg;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
        return videoGameRepository.findByGenre(Genre.valueOf(genre.toUpperCase()));
    }

}

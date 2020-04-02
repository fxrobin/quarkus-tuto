package fr.fxjavadevblog.qjg;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoGameRepository extends CrudRepository<VideoGame, String> {

    List<VideoGame> findByGenre(Genre genre);
}
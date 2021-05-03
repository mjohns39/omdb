package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    List<Movie> findByTitle(@Param("title") String title);

    List<Movie> findByActorsContaining(@Param("actor") String actor);

}

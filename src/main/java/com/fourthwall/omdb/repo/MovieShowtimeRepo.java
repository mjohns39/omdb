package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.MovieShowtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieShowtimeRepo extends JpaRepository<MovieShowtime, Integer> {

    List<MovieShowtime> findByMovieId(@Param("movieId") Integer movieId);
}

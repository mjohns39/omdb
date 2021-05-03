package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.MovieShowtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieShowtimeRepo extends JpaRepository<MovieShowtime, Integer> {
}

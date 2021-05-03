package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}

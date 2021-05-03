package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.CriticRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriticRatingRepo extends JpaRepository<CriticRating, Integer> {
}

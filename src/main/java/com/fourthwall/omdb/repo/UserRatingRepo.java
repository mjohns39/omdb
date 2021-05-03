package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.UserRating;
import com.fourthwall.omdb.domain.id.UserRatingsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRatingRepo extends JpaRepository<UserRating, UserRatingsId> {
}

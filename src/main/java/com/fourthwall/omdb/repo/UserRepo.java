package com.fourthwall.omdb.repo;

import com.fourthwall.omdb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}

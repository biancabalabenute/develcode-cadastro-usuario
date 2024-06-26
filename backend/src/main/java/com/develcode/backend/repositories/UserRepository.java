package com.develcode.backend.repositories;

import com.develcode.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findByIdWithImage(Long id);

    @Query("SELECT u FROM User u")
    List<User> findAllWithImage();
}

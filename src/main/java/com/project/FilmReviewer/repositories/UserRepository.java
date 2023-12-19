package com.project.FilmReviewer.repositories;

import com.project.FilmReviewer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> getUserById(Integer id);

}

package com.project.FilmReviewer.repositories;

import com.project.FilmReviewer.models.Film;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    void deleteById(@NonNull Integer id);

    Optional<Film> getFilmById(Integer id);
}

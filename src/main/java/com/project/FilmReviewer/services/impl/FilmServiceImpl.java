package com.project.FilmReviewer.services.impl;

import com.project.FilmReviewer.models.Film;
import com.project.FilmReviewer.models.utility.FilmRequest;
import com.project.FilmReviewer.models.User;
import com.project.FilmReviewer.models.utility.NewMarkRequest;
import com.project.FilmReviewer.repositories.FilmRepository;
import com.project.FilmReviewer.repositories.UserRepository;
import com.project.FilmReviewer.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final UserRepository userRepository;

    private final FilmRepository filmRepository;

    @Override
    public String addFilm(FilmRequest filmRequest, Integer userId) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Film film = Film.builder()
                .filmTitle(filmRequest.getFilmTitle())
                .mark(filmRequest.getMark())
                .userOpinion(filmRequest.getUserOpinion())
                .user(user)
                .build();

        return filmRepository.save(film).getFilmTitle();
    }

    @Override
    public Boolean deleteFilm(Integer filmId, Integer userId) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        boolean checkIfUserHasFilm = user.getFilms().removeIf(film -> Objects.equals(film.getId(),filmId));

        if(!checkIfUserHasFilm)
            throw new RuntimeException("User does not have this film id");

        filmRepository.deleteById(filmId);
        return Boolean.TRUE;
    }

    @Override
    public String updateFilmMArk(NewMarkRequest newMark, Integer filmId) {
        Film film = filmRepository.getFilmById(filmId).orElseThrow(() -> new RuntimeException("Film not found"));
        User user = film.getUser();
        System.out.println(newMark.getNewMark());
        user.getFilms().remove(film);

        film.setMark(newMark.getNewMark());
        user.getFilms().add(film);

        filmRepository.save(film);
        userRepository.save(user);

        return "Mark was updated";
    }
}

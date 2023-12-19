package com.project.FilmReviewer.services;

import com.project.FilmReviewer.models.utility.FilmRequest;
import com.project.FilmReviewer.models.utility.NewMarkRequest;

public interface FilmService {
    String addFilm(FilmRequest filmRequest, Integer userId);

    Boolean deleteFilm(Integer filmId, Integer userId);

    String updateFilmMArk(NewMarkRequest newMark, Integer filmId);
}


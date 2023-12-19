package com.project.FilmReviewer.services;

import com.project.FilmReviewer.models.utility.ChangePasswordRequest;
import com.project.FilmReviewer.models.Film;
import com.project.FilmReviewer.models.utility.UserRequest;

import java.util.Set;

public interface UserService {
    Set<Film> getFilmsByUserId(Integer id);

    String createUser(UserRequest userRequest);

    String changePassword(Integer userId, ChangePasswordRequest changePasswordRequest);

    void deleteUser(Integer userId);
}

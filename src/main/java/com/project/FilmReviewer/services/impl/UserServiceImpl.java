package com.project.FilmReviewer.services.impl;

import com.project.FilmReviewer.models.utility.ChangePasswordRequest;
import com.project.FilmReviewer.models.Film;
import com.project.FilmReviewer.models.User;
import com.project.FilmReviewer.models.utility.UserRequest;
import com.project.FilmReviewer.models.enums.Role;
import com.project.FilmReviewer.repositories.UserRepository;
import com.project.FilmReviewer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Set<Film> getFilmsByUserId(Integer id) {
        return userRepository.getUserById(id)
                .orElseThrow(() -> new RuntimeException("user id not found"))
                .getFilms();
    }

    @Override
    public String createUser(UserRequest userRequest) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        User user = User.builder()
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .roles(roles)
                .build();

        return userRepository.save(user).getUsername();
    }

    @Override
    public String changePassword(Integer userId, ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.getUserById(userId).orElseThrow(() -> new RuntimeException("Invalid id"));

        if(!user.getPassword().equals(changePasswordRequest.getOldPassword()))
            throw new RuntimeException("Invalid password");

        user.setPassword(changePasswordRequest.getNewPassword());

        return userRepository.save(user).getUsername();
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.findById(userId).ifPresent(userRepository::delete);
    }
}

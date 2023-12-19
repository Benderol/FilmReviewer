package com.project.FilmReviewer.controllers;

import com.project.FilmReviewer.models.Film;
import com.project.FilmReviewer.models.utility.ChangePasswordRequest;
import com.project.FilmReviewer.models.utility.UserRequest;
import com.project.FilmReviewer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Set<Film>> getFilms(@PathVariable Integer userId ){
        return ResponseEntity.ok(userService.getFilmsByUserId(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser( @RequestBody UserRequest userRequest ){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PostMapping("/update/{userId}")
    public ResponseEntity<String> updateUser( @RequestBody ChangePasswordRequest changePasswordRequest, @PathVariable Integer userId ){
        return ResponseEntity.ok(userService.changePassword(userId,changePasswordRequest));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser( @PathVariable Integer userId ){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

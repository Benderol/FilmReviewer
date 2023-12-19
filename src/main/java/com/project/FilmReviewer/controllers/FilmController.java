package com.project.FilmReviewer.controllers;

import com.project.FilmReviewer.models.utility.FilmRequest;
import com.project.FilmReviewer.models.utility.NewMarkRequest;
import com.project.FilmReviewer.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping("/add/user/{userId}")
    public ResponseEntity<String> addFilm(@RequestBody FilmRequest filmRequest, @PathVariable Integer userId){
        return ResponseEntity.ok(filmService.addFilm(filmRequest, userId));
    }

    @PostMapping("/update/{filmId}")
    public ResponseEntity<String> updateFilmMark(@RequestBody NewMarkRequest newMark, @PathVariable Integer filmId){
        return ResponseEntity.ok(filmService.updateFilmMArk(newMark, filmId));
    }

    @DeleteMapping("/delete/{filmId}/user/{userId}")
    public ResponseEntity<Boolean> deleteFilm(@PathVariable Integer filmId, @PathVariable Integer userId){
        return ResponseEntity.ok(filmService.deleteFilm(filmId, userId));
    }
}

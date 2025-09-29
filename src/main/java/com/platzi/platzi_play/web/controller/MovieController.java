package com.platzi.platzi_play.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movieDto = this.movieService.getAll();
        if (movieDto.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable("id") long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movieSaved = this.movieService.save(movieDto);
        if(movieSaved == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }
    

}

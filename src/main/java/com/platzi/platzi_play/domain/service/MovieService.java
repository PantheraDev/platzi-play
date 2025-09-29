package com.platzi.platzi_play.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto save(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }
}

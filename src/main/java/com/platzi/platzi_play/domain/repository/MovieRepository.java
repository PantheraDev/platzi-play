package com.platzi.platzi_play.domain.repository;

import java.util.List;

import com.platzi.platzi_play.domain.dto.MovieDto;

public interface MovieRepository {
    List<MovieDto> getAll();

    MovieDto getById(long id);

    MovieDto save(MovieDto movieDto);
}

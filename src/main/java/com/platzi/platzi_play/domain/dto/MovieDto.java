package com.platzi.platzi_play.domain.dto;

import com.platzi.platzi_play.domain.Genre;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        String releaseDate,
        String rating,
        String state) {

}

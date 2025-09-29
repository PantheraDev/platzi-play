package com.platzi.platzi_play.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.persistence.entity.MovieEntity;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "genre", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "rating", target = "rating")
    //@Mapping(source = "state", target = "state")
    MovieDto toDto(MovieEntity movie);
    List<MovieDto> toDto(Iterable<MovieEntity> movies);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genre", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movie);
}

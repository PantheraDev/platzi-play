package com.platzi.platzi_play.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.repository.MovieRepository;
import com.platzi.platzi_play.persistence.crud.CrudMovieEntity;
import com.platzi.platzi_play.persistence.entity.MovieEntity;
import com.platzi.platzi_play.persistence.mapper.MovieMapper;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());

    }

    @Override
    public MovieDto getById(long id) {
        return this.movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setState("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

}

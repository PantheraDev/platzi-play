package com.platzi.platzi_play.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.platzi.platzi_play.persistence.entity.MovieEntity;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

}

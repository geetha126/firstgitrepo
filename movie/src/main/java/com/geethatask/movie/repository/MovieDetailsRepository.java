package com.geethatask.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.altimetrik.ee.demo.entity.OrderDetailsEntity;
import com.geethatask.movie.entity.MovieDetailsEntity;


public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, Integer> {

	@Query(value = "Select * FROM movie_menu c where (c.movie_name = :movieName)")
	List<MovieDetailsEntity> findByMovieName(String movieName);
	
	@Query(value = "Select * FROM movie_menu c where (c.movie_id = :movieId)")
	List<MovieDetailsEntity> findByMovieId(int  movieId);
	
	
	

	
}

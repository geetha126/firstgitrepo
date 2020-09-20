	package com.geethatask.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.geethatask.movie.entity.MovieTicketEntity;



@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicketEntity, Integer> {

	@Query(value = "Select * FROM movie r where (r.movie_rating = :ratingId)")
	List<MovieTicketEntity> findByMovieRating(int rating);
	
	@Query(value = "Select * FROM movie r where (r.movie_id = :movieId)")
	List<MovieTicketEntity> findByMovieId(List<Integer> movieId);
	

}

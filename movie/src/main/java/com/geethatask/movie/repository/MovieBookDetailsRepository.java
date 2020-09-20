package com.geethatask.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.geethatask.movie.entity.MovieBookDetailsEntity;


@Repository
public interface MovieBookDetailsRepository extends JpaRepository<MovieBookDetailsEntity, Integer> {
	@Query(value = "Insert into movie o where (o.user_name=:userName) and (o.movie_rating=:movieRating) and (o.ticket_price=:ticketPrice)")
//	List<MovieBookDetailsEntity> save(MovieBookDetailsEntity orderDetailsEntity);
	<S extends MovieBookDetailsEntity> S save(MovieBookDetailsEntity orderDetailsEntity);
	
	@Query(value = "Select * FROM movie o where (o.movie_id = :movieId)")
	Optional<MovieBookDetailsEntity> findById(int orderId);
	
}

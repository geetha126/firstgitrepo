package com.geethatask.movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Data
@Builder
@Table(name = "movie")
public class MovieTicketEntity {
	
	@Id
	@Column(name = "movie_id")
	public int movieId;
	
	@Column(name = "movie_name")
	public String movieName;
	
	@Column(name = "movie_rating")
	public int movieRating;
	
	@OneToMany(mappedBy = "MovieDetailsEntity")
	public List<MovieDetailsEntity> movieDetailsEntityList;
	

	public int getmovieId() {
		return movieId;
	}

	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getmovieName() {
		return movieName;
	}

	public void setmovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getmovieRating() {
		return movieRating;
	}

	public void setmovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public List<MovieDetailsEntity> getMovieDetailsEntityList() {
		return movieDetailsEntityList;
	}

	public void setMovieDetailsEntityList(List<MovieDetailsEntity> movieDetailsEntityList) {
		this.movieDetailsEntityList = movieDetailsEntityList;
	}

	
}

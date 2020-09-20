/**
 * 
 */
package com.geethatask.movie.model;

import java.util.List;
import java.util.stream.Collectors;

import com.geethatask.movie.entity.MovieTicketEntity;

/**
 * @author Geetha
 *
 */
public class MovieTicketModel {
	
	public int movieId;
	
	public String movieName;
	
	public int movieRating;

	public static List<MovieTicketModel> formMovieTicketModel(List<MovieTicketEntity> movieTicketList) {
		return movieTicketList.stream().map(movieTicket -> {
			MovieTicketModel movieTicketModel = new MovieTicketModel();
			movieTicketModel.setMovieId(movieTicket.getmovieId());
			movieTicketModel.setMovieName(movieTicket.getmovieName());
			movieTicketModel.setMovieRating(movieTicket.getmovieRating());
			return movieTicketModel;
		}).collect(Collectors.toList());
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

}

package com.geethatask.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_book_details")
public class MovieBookDetailsEntity {

	@Id
	@Column(name = "movie_book_id")
	public int movieBookId;
	
	@Column(name = "user_name")
	public String userName;

	@Column(name = "movie_rating")
	public int movieRating;

	@Column(name = "ticket_price")
	public int ticketPrice;

	public int getMovieBookId() {
		return movieBookId;
	}

	public void setMovieBookId(int movieBookId) {
		this.movieBookId = movieBookId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


}

package com.geethatask.movie.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movie_menu")
public class MovieDetailsEntity {
	
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int movieId;

	@Column(name = "movie_name")
	public String movieName;
	
	@Column(name = "movie_availability")
	public boolean movieAvailability;
	
	@Column(name = "peak_price")
	public int peakPrice;
	
	@Column(name = "regular_price")
	public int regularPrice;
	
	@ManyToOne
	public MovieTicketEntity movieTicketEntity;

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

	public boolean ismovieAvailability() {
		return movieAvailability;
	}

	public void setmovieAvailability(boolean movieAvailability) {
		this.movieAvailability = movieAvailability;
	}


	public int getPeakPrice() {
		return peakPrice;
	}

	public void setPeakPrice(int peakPrice) {
		this.peakPrice = peakPrice;
	}

	public int getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(int regularPrice) {
		this.regularPrice = regularPrice;
	}

	public MovieTicketEntity getmovieTicketEntity() {
		return movieTicketEntity;
	}

	public void setmovieTicketEntity(MovieTicketEntity movieTicketEntity) {
		this.movieTicketEntity = movieTicketEntity;
	}


}

package com.geethatask.movie.model;

import java.util.List;
import java.util.stream.Collectors;

import com.geethatask.movie.entity.MovieBookDetailsEntity;


public class MovieBookDetailsModel {

	public int movieBookId;
	
	public String userName;
	
	public int movieRating;

	public int ticketPrice;
	
	
	public static List<MovieBookDetailsModel> formSearchResultModel(List<MovieBookDetailsEntity> bookDetailsEntityList) {
		return bookDetailsEntityList.stream().map(orderDetailsEntity -> {
			MovieBookDetailsModel orderDetailsModel = new MovieBookDetailsModel();
			orderDetailsModel.setMovieBookId(orderDetailsEntity.getMovieBookId());
			orderDetailsModel.setUserName(orderDetailsEntity.getUserName());
			orderDetailsModel.setMovieRating(orderDetailsEntity.getMovieRating());
			orderDetailsModel.setTicketPrice(orderDetailsEntity.getTicketPrice());
			return orderDetailsModel;
		}).collect(Collectors.toList());
	}


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

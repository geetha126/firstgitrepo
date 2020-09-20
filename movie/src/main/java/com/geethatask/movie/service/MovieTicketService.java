/**
 * 
 */
package com.geethatask.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geethatask.movie.entity.MovieBookDetailsEntity;
import com.geethatask.movie.model.MovieBookDetailsModel;
import com.geethatask.movie.model.MovieTicketModel;

/**
 * @author Geetha
 *
 */
@Service
public interface MovieTicketService {
		
		List<MovieTicketModel> findAll(String applicationName);

		void storeTicketDetails(MovieBookDetailsModel movieBookDetailsModel);

		List<MovieTicketModel> searchByRating(int rating);
		
		MovieBookDetailsEntity getTicketDetails(int orderId);

		List<MovieTicketModel> searchByMovieName(String movieName);


}

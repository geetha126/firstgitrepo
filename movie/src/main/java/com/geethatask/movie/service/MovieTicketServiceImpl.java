/**
 * 
 */
package com.geethatask.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.geethatask.movie.bean.PairedComponentDetailsBean;
import com.geethatask.movie.entity.MovieBookDetailsEntity;
import com.geethatask.movie.entity.MovieDetailsEntity;
import com.geethatask.movie.entity.MovieTicketEntity;
import com.geethatask.movie.model.MovieBookDetailsModel;
import com.geethatask.movie.model.MovieTicketModel;
import com.geethatask.movie.repository.ComponentDetailsRepository;
import com.geethatask.movie.repository.MovieBookDetailsRepository;
import com.geethatask.movie.repository.MovieDetailsRepository;
import com.geethatask.movie.repository.MovieTicketRepository;

/**
 * @author Geetha
 *
 */
public class MovieTicketServiceImpl implements MovieTicketService{
	
	private static final List<MovieTicketModel> EMPTY = null;

	@Autowired
	private ComponentDetailsRepository componentDetailsRepository;
	
	@Autowired
	private MovieDetailsRepository movieDetailsRepository;
	
	@Autowired
	private MovieBookDetailsRepository movieBookDetailsRepository;
	
	@Autowired
	private MovieTicketRepository movieTicketRepository;

		@Override
		public List<MovieTicketModel> findAll(final String applicationName) {
			final PairedComponentDetailsBean pairedComponentDetails = new PairedComponentDetailsBean(
					this.componentDetailsRepository.getByComponentName(applicationName),
					this.componentDetailsRepository.getByComponentNameNotIn(applicationName));
			return (List<MovieTicketModel>) pairedComponentDetails;
	}


	@Override
	public List<MovieTicketModel> searchByRating(int rating) {
		List<MovieTicketEntity> movieTicketList = movieTicketRepository.findByMovieRating(rating);
		List<MovieTicketModel> movieTicketModelList;
		if(CollectionUtils.isEmpty(movieTicketList)) {
			return EMPTY;
		} else {
			movieTicketModelList = MovieTicketModel.formMovieTicketModel(movieTicketList);
		}
		return movieTicketModelList;

	}


	@Override
	public List<MovieTicketModel> searchByMovieName(String movieName) {
		List<MovieDetailsEntity> movieDetailsEntityList = movieDetailsRepository.findByMovieName(movieName);
		List<Integer> movieIdList = new ArrayList<>();
		if(CollectionUtils.isEmpty(movieDetailsEntityList)) {
			return EMPTY;
		} else {
			movieDetailsEntityList.stream().forEach(movieDetailsEntity -> {
				movieIdList.add(movieDetailsEntity.getmovieTicketEntity().getmovieId());});
		}
		List<MovieTicketEntity> movieTicketEntityList = movieTicketRepository.findByMovieId(movieIdList);
		return MovieTicketModel.formMovieTicketModel(movieTicketEntityList);
		}

	@Override
	public void storeTicketDetails(MovieBookDetailsModel movieBookDetailsModel) {
		MovieBookDetailsEntity orderDetailsEntity = new MovieBookDetailsEntity();
		orderDetailsEntity.setMovieRating(movieBookDetailsModel.getMovieRating());
		orderDetailsEntity.setUserName(movieBookDetailsModel.getUserName());
		orderDetailsEntity.setTicketPrice(movieBookDetailsModel.getTicketPrice());
		try {
			movieBookDetailsRepository.save(orderDetailsEntity);
		} 
		catch(Exception exception) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public MovieBookDetailsEntity getTicketDetails(int ticketId) {
		Optional<MovieBookDetailsEntity> orderDetailsEntityOptional = null;
		if(Objects.nonNull(ticketId)) {
			orderDetailsEntityOptional = movieBookDetailsRepository.findById(ticketId);
			if(orderDetailsEntityOptional.isPresent()) {
				return orderDetailsEntityOptional.get();
			} else {
				Optional.empty();
			} 
		} 
		return orderDetailsEntityOptional.get();
	}

}

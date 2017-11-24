package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.HotelService;
import com.demo.successcode.HotelSuccessCode;
import com.demo.util.CustomResponse;
import com.demo.vm.HotelVM;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private static final Logger log = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public ResponseEntity<CustomResponse> getAllHotels() {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getAll(), null), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomResponse> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getById(id), null), HttpStatus.OK);
	}

	@GetMapping("/price/{maxPrice}")
	public ResponseEntity<CustomResponse> findByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByMaxPrice(maxPrice), null),
				HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> insert(@RequestBody HotelVM hotelVM) {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.add(hotelVM), null), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<CustomResponse> update(@RequestBody HotelVM hotelVM) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.update(hotelVM), null),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomResponse> deleteById(@PathVariable(name = "id") String id) {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.delete(id), null), HttpStatus.OK);
	}

	@GetMapping("/city/{cityName}")
	public ResponseEntity<CustomResponse> findByCity(@PathVariable(name = "cityName") String cityName) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByCityName(cityName), null),
				HttpStatus.OK);
	}

	@GetMapping("/user/{userName}")
	public ResponseEntity<CustomResponse> findByRating(@PathVariable(name = "userName") String userName) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByCommentUserName(userName), null),
				HttpStatus.OK);
	}

	@GetMapping("/rating/{rating}")
	public ResponseEntity<CustomResponse> findByReviewRating(@PathVariable(name = "rating") double rating) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByRating(rating), null),
				HttpStatus.OK);
	}

	/*@PostMapping("{hotelId}/review/")
	public ResponseEntity<CustomResponse> addReview(@RequestBody Review review) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByRating(rating), null),
				HttpStatus.OK);
	}*/

	@GetMapping("/{hotelId}/reviews")
	public ResponseEntity<CustomResponse> getReview(@PathVariable("hotelId") String hotelId) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getReviewByHotelId(hotelId), null),
				HttpStatus.OK);
	}

	@GetMapping("/like/{hotelName}")
	public ResponseEntity<CustomResponse> findByNameLike(@PathVariable(name = "hotelName") String hotelName) {
		return new ResponseEntity<>(new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
				HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getByHotelNameStartsWith(hotelName), null),
				HttpStatus.OK);
	}

	@GetMapping("/random/{size}")
	public ResponseEntity<CustomResponse> getRandom(@PathVariable(name = "size") int size) {
		return new ResponseEntity<>(
				new CustomResponse(HotelSuccessCode.HOTEL_FETCHED.getCode(),
						HotelSuccessCode.HOTEL_FETCHED.getMessage(), hotelService.getRandom(size), null),
				HttpStatus.OK);
	}
}

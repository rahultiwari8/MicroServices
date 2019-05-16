package io.javabrains.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
	
	@RequestMapping("users/{userId}")
    public UserRating getuserRating(@PathVariable("userId") String userId) {
         List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));
		UserRating userrating = new UserRating();
		userrating.setUserRating(ratings);
		return userrating;
    }

}

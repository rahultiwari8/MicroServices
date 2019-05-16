package io.javabrains.moviecatalogservice.resources;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
    private WebClient.Builder webClientBuilder;
	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable("userid")String userid)
	{
		
		// get the all rated movie ids
		
		
		
		
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userid, UserRating.class);
		// For reach movie id call movie info service 
		return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8082/movies/" + rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			 						
			
         // Put them all together
            return new CatalogItem(movie.getMovieName(), "Description", rating.getRating());
        })
				
        .collect(Collectors.toList());
			
			
		
		
			
		
		
		
		
	}

}

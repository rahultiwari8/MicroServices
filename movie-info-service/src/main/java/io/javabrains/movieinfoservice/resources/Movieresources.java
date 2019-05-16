package io.javabrains.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class Movieresources {
	@RequestMapping("/{movieID}")
	public Movie getMovieList(@PathVariable("movieID")String movieID)
	{
		return new Movie(movieID,"TestMovie");
		
	}

}

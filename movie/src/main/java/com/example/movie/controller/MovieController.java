package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovie();
    }

    @GetMapping("/getMovie/{movieId}")
    public Movie getMovie(@PathVariable String movieId){
        return movieService.getMovie(movieId);
    }
    @GetMapping("/movies/genre")
    public List<Movie> getMoviesByGenre(@RequestParam String genre) {
        return movieService.getByGenre(genre);
    }
    @PostMapping("/createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @PutMapping("/updateMovie/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable String movieId) {
        return movieService.update(movie, movieId);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public String deleteMovie(@PathVariable String movieId) {
        movieService.delete(movieId);
        return "Movie deleted";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        movieService.deleteAll();
        return "All movies deleted";
    }

}

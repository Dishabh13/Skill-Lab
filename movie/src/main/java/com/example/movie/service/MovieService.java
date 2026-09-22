package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }
    public Movie getMovie(String movieId){
        return movieRepository.findById(movieId).orElse(null);
    }
    public Movie create(Movie movie){
        return movieRepository.save(movie);
    }
    public Movie update(Movie movie,String movieId){
        Movie existing = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + movieId));
        existing.setTitle(movie.getTitle());
        existing.setDirector(movie.getDirector());
        existing.setGenre(movie.getGenre());
        existing.setReleaseYear(movie.getReleaseYear());
        return movieRepository.save(existing);
    }
    public void delete(String movieId){
        movieRepository.deleteById(movieId);
    }
    public void deleteAll(){
        movieRepository.deleteAll();
    }
}

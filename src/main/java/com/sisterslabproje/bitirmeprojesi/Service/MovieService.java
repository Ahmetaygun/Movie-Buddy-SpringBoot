package com.sisterslabproje.bitirmeprojesi.Service;

import com.sisterslabproje.bitirmeprojesi.Repository.MovieRepository;
import com.sisterslabproje.bitirmeprojesi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long movieId, Movie movieDetails) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new NoSuchElementException("Movie not found with id: " + movieId));

        // Film detaylarını güncelle
        movie.setName(movieDetails.getName());
        movie.setDescription(movieDetails.getDescription());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRating(movieDetails.getRating());

        // Güncellenmiş filmi kaydet ve döndür
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + movieId));
    }

}
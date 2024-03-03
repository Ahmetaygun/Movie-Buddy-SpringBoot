package com.sisterslabproje.bitirmeprojesi.Controller;

import com.sisterslabproje.bitirmeprojesi.Service.MovieService;
import com.sisterslabproje.bitirmeprojesi.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(movieId, movieDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok().build();
    }
}
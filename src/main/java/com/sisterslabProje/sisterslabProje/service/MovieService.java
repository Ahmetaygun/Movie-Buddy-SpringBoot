package com.sisterslabProje.sisterslabProje.service;

import com.sisterslabProje.sisterslabProje.dto.MovieDTO;
import com.sisterslabProje.sisterslabProje.dto.UserDTO;
import com.sisterslabProje.sisterslabProje.model.Movie;
import com.sisterslabProje.sisterslabProje.model.User;
import com.sisterslabProje.sisterslabProje.repository.MovieRepository;
import com.sisterslabProje.sisterslabProje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setRating(movieDTO.getRating());
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long movieId, MovieDTO newMovieDTO) {
        Movie existingMovie = movieRepository.findById(movieId).orElse(null);
        if (existingMovie != null) {
            existingMovie.setName(newMovieDTO.getName());
            existingMovie.setDescription(newMovieDTO.getDescription());
            existingMovie.setReleaseDate(newMovieDTO.getReleaseDate());
            existingMovie.setRating(newMovieDTO.getRating());
            return movieRepository.save(existingMovie);
        }
        return null;
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    public boolean addToWatchlist(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (user != null && movie != null) {
            if (!user.getWatchlist().contains(movie)) {
                user.getWatchlist().add(movie);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }



    public UserDTO removeFromWatchlist(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Movie movieToRemove = movieRepository.findById(movieId).orElse(null);
            if (movieToRemove != null && user.getWatchlist().contains(movieToRemove)) {
                user.getWatchlist().remove(movieToRemove);
                userRepository.save(user);
                return UserDTO.fromUser(user);
            } else {
                return null;
            }
        }
        return null;
    }

    public UserDTO markAsWatched(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Movie movie = movieRepository.findById(movieId).orElse(null);
            if (movie != null) {
                user.getWatchedMovies().add(movie);
                userRepository.save(user);
                return UserDTO.fromUser(user);
            } else {
                return null;
            }
        }
        return null;
    }

}
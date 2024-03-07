package com.sisterslabProje.sisterslabProje.controller;

import com.sisterslabProje.sisterslabProje.dto.MovieDTO;
import com.sisterslabProje.sisterslabProje.dto.UserDTO;
import com.sisterslabProje.sisterslabProje.model.Movie;
import com.sisterslabProje.sisterslabProje.model.User;
import com.sisterslabProje.sisterslabProje.repository.MovieRepository;
import com.sisterslabProje.sisterslabProje.repository.UserRepository;
import com.sisterslabProje.sisterslabProje.service.MovieService;
import com.sisterslabProje.sisterslabProje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie : allMovies) {
            //filmin tüm bilgilerini yazdırdım burada
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(movie.getId());
            movieDTO.setName(movie.getName());
            movieDTO.setDescription(movie.getDescription());
            movieDTO.setReleaseDate(movie.getReleaseDate());
            movieDTO.setRating(movie.getRating());

            // usersten sadece fovorilerine ekleyen kullanıcıların id bilgisini yazdırdım burada
            List<Long> userIds = new ArrayList<>();
            for (User user : movie.getUsers()) {
                userIds.add(user.getId());
            }
            movieDTO.setUsers(userIds);

            movieDTOList.add(movieDTO);
        }

        return movieDTOList;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDTO) {
        Movie addedMovie = movieService.addMovie(movieDTO);
        if (addedMovie != null) {
            return ResponseEntity.ok("Film başarıyla eklendi.");
        } else {
            return ResponseEntity.badRequest().body("Film eklenirken bir hata oluştu.");
        }
    }

    @PutMapping("/update/{movieId}")
    public ResponseEntity<String> updateMovie(@PathVariable Long movieId, @RequestBody MovieDTO movieDTO) {
        Movie updatedMovie = movieService.updateMovie(movieId, movieDTO);
        if (updatedMovie != null) {
            return ResponseEntity.ok("Film başarıyla güncellendi.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
        try {
            movieService.deleteMovie(movieId);
            return ResponseEntity.ok("Film başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Film silinirken bir hata oluştu.");
        }
    }

    @PostMapping("/add-to-watchlist/{userId}/{movieId}")
    public ResponseEntity<String> addToWatchlist(@PathVariable Long userId, @PathVariable Long movieId) {
        boolean addedToWatchlist = movieService.addToWatchlist(userId, movieId);
        if (addedToWatchlist) {
            return ResponseEntity.ok("Film başarıyla izleme listesine eklendi.");
        } else {
            return ResponseEntity.badRequest().body("Kullanıcı, film bulunamadı veya film zaten izleme listesinde.");
        }
    }

    @PostMapping("/remove-from-watchlist/{userId}/{movieId}")
    public ResponseEntity<String> removeFromWatchlist(@PathVariable Long userId, @PathVariable Long movieId) {
        UserDTO userDTO = movieService.removeFromWatchlist(userId, movieId);
        if (userDTO != null) {
            return ResponseEntity.ok("Film izleme listesinden başarıyla kaldırıldı.");
        } else {
            return ResponseEntity.ok("İzleme listesinde film bulunamadı.");
        }
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/mark-as-watched/{userId}/{movieId}")
    public ResponseEntity<String> markAsWatched(@PathVariable Long userId, @PathVariable Long movieId) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (user != null && movie != null) {
            if (!user.getWatchedMovies().contains(movie)) {
                user.getWatchedMovies().add(movie);
                userRepository.save(user);
                return ResponseEntity.ok("Film izlendi olarak işaretlendi.");
            } else {
                return ResponseEntity.badRequest().body("Bu film zaten izlendi olarak işaretlenmiş.");
            }
        } else {
            return ResponseEntity.badRequest().body("Kullanıcı veya film bulunamadı.");
        }
    }

    @GetMapping("/watched-movies/{userId}")
    public ResponseEntity<List<MovieDTO>> getWatchedMovies(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Movie> watchedMovies = user.getWatchedMovies();
            List<MovieDTO> watchedMovieDTOs = new ArrayList<>();
            for (Movie movie : watchedMovies) {
                MovieDTO movieDTO = new MovieDTO();
                movieDTO.setId(movie.getId());
                movieDTO.setName(movie.getName());
                movieDTO.setDescription(movie.getDescription());
                movieDTO.setRating(movie.getRating());
                watchedMovieDTOs.add(movieDTO);
            }
            return ResponseEntity.ok(watchedMovieDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/watchlist/{userId}")
    public ResponseEntity<List<MovieDTO>> getWatchlistMovies(@PathVariable Long userId) {
        List<MovieDTO> watchlistMovies = userService.getWatchlistMovies(userId);
        if (!watchlistMovies.isEmpty()) {
            return ResponseEntity.ok(watchlistMovies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
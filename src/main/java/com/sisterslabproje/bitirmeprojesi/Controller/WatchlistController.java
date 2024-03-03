package com.sisterslabproje.bitirmeprojesi.Controller;

import com.sisterslabproje.bitirmeprojesi.Service.MovieService;
import com.sisterslabproje.bitirmeprojesi.Service.UserService;
import com.sisterslabproje.bitirmeprojesi.Service.WatchlistService;
import com.sisterslabproje.bitirmeprojesi.model.Movie;
import com.sisterslabproje.bitirmeprojesi.model.User;
import com.sisterslabproje.bitirmeprojesi.model.Watchlist;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;
    private final UserService userService;
    private final MovieService movieService;

    public WatchlistController(WatchlistService watchlistService, UserService userService, MovieService movieService) {
        this.watchlistService = watchlistService;
        this.userService = userService;
        this.movieService = movieService;
    }

    @PostMapping("/{userId}/{movieId}")
    public Watchlist addToWatchlist(@PathVariable Long userId, @PathVariable Long movieId) {
        User user = userService.getUserById(userId);
        Movie movie = movieService.getMovieById(movieId);
        return watchlistService.addToWatchlist(user, movie);
    }

    @DeleteMapping("/{watchlistId}")
    public void removeFromWatchlist(@PathVariable Long watchlistId) {
        Watchlist watchlist = watchlistService.getWatchlistById(watchlistId);
        watchlistService.removeFromWatchlist(watchlist);
    }

    @PutMapping("/watched/{watchlistId}")
    public void markAsWatched(@PathVariable Long watchlistId) {
        Watchlist watchlist = watchlistService.getWatchlistById(watchlistId);
        watchlistService.markAsWatched(watchlist);
    }

    @GetMapping("/{userId}")
    public List<Watchlist> getWatchlistByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return watchlistService.getWatchlistByUser(user);
    }
}
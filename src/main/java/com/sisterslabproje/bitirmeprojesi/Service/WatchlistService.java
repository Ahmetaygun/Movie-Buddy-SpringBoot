package com.sisterslabproje.bitirmeprojesi.Service;

import com.sisterslabproje.bitirmeprojesi.Repository.WatchlistRepository;
import com.sisterslabproje.bitirmeprojesi.model.Movie;
import com.sisterslabproje.bitirmeprojesi.model.User;
import com.sisterslabproje.bitirmeprojesi.model.Watchlist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    private final WatchlistRepository watchlistRepository;

    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public List<Watchlist> getWatchlistByUser(User user) {
        return watchlistRepository.findByUser(user);
    }

    public Watchlist addToWatchlist(User user, Movie movie) {
        Watchlist watchlist = new Watchlist();
        watchlist.setUser(user);
        watchlist.setMovie(movie);
        return watchlistRepository.save(watchlist);
    }

    public void removeFromWatchlist(Watchlist watchlist) {
        watchlistRepository.delete(watchlist);
    }

    public void markAsWatched(Watchlist watchlist) {
        watchlist.setWatched(true);
        watchlistRepository.save(watchlist);
    }
    public Watchlist getWatchlistById(Long watchlistId) {
        return watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new IllegalArgumentException("Watchlist not found with id: " + watchlistId));
    }

}
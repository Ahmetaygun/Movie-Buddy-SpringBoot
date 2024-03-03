package com.sisterslabproje.bitirmeprojesi.Repository;

import com.sisterslabproje.bitirmeprojesi.model.User;
import com.sisterslabproje.bitirmeprojesi.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    List<Watchlist> findByUser(User user);

}
package com.sisterslabproje.bitirmeprojesi.Repository;

import com.sisterslabproje.bitirmeprojesi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
package com.sisterslabProje.sisterslabProje.repository;


import com.sisterslabProje.sisterslabProje.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

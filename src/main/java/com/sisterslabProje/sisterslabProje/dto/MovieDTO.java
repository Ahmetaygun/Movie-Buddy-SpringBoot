package com.sisterslabProje.sisterslabProje.dto;


import com.sisterslabProje.sisterslabProje.model.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String name;
    private String description;
    private Date releaseDate;
    private int rating;
    private List<Long> users;

    public MovieDTO() {}

    public MovieDTO(Long id, String name, String description, Date releaseDate, int rating, List<Long> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.users = users;
    }

    public static MovieDTO fromMovie(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setRating(movie.getRating());
        return movieDTO;
    }

    public static List<MovieDTO> fromMovies(List<Movie> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for (Movie movie : movies) {
            movieDTOs.add(fromMovie(movie));
        }
        return movieDTOs;
    }

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setId(this.id);
        movie.setName(this.name);
        movie.setDescription(this.description);
        movie.setReleaseDate(this.releaseDate);
        movie.setRating(this.rating);
        return movie;
    }
}
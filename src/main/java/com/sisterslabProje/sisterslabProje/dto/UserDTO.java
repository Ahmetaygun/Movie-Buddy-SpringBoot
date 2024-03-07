package com.sisterslabProje.sisterslabProje.dto;

import com.sisterslabProje.sisterslabProje.model.Movie;
import com.sisterslabProje.sisterslabProje.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private List<MovieDTO> watchedMovies; // İzlenen filmlerin detayları
    private List<MovieDTO> watchlist; // Watchlist'teki filmlerin detayları

    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        // İzlenen filmlerin detaylarını alıyoruz
        List<MovieDTO> watchedMovieDTOs = new ArrayList<>();
        for (Movie movie : user.getWatchedMovies()) {
            watchedMovieDTOs.add(MovieDTO.fromMovie(movie));
        }
        userDTO.setWatchedMovies(watchedMovieDTOs);

        // Watchlist'teki filmlerin detaylarını alıyoruz
        List<MovieDTO> watchlistMovieDTOs = new ArrayList<>();
        for (Movie movie : user.getWatchlist()) {
            watchlistMovieDTOs.add(MovieDTO.fromMovie(movie));
        }
        userDTO.setWatchlist(watchlistMovieDTOs);

        return userDTO;
    }
}


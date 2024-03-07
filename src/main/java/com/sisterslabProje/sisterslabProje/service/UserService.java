package com.sisterslabProje.sisterslabProje.service;


import com.sisterslabProje.sisterslabProje.dto.MovieDTO;
import com.sisterslabProje.sisterslabProje.dto.UserDTO;
import com.sisterslabProje.sisterslabProje.model.Movie;
import com.sisterslabProje.sisterslabProje.model.User;
import com.sisterslabProje.sisterslabProje.repository.MovieRepository;
import com.sisterslabProje.sisterslabProje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }


    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());

            // İzlenen filmlerin detaylarını alıyoruz
            List<MovieDTO> watchedMovieDTOs = new ArrayList<>();
            for (Movie movie : user.getWatchedMovies()) {
                MovieDTO movieDTO = new MovieDTO();
                movieDTO.setId(movie.getId());
                movieDTO.setName(movie.getName());
                //diğer verilerin null dönmesini istemiyorsam onlarıda eklemek lazım
                watchedMovieDTOs.add(movieDTO);
            }
            userDTO.setWatchedMovies(watchedMovieDTOs);

            // Watchlist'teki filmlerin detaylarını alıyoruz
            List<MovieDTO> watchlistMovieDTOs = new ArrayList<>();
            for (Movie movie : user.getWatchlist()) {
                MovieDTO movieDTO = new MovieDTO();
                movieDTO.setId(movie.getId());
                movieDTO.setName(movie.getName());
                //diğer verilerin null dönmesini istemiyorsam onlarıda eklemek lazım
                watchlistMovieDTOs.add(movieDTO);
            }
            userDTO.setWatchlist(watchlistMovieDTOs);

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }


    public UserDTO updateUser(Long userId, UserDTO newUserDTO) {
        User userToUpdate = userRepository.findById(userId).orElse(null);
        if (userToUpdate != null) {
            updateEntity(userToUpdate, newUserDTO);
            User updatedUser = userRepository.save(userToUpdate);
            return convertToDTO(updatedUser);
        }
        return null;
    }

    public boolean changePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserDTO markAsWatched(Long userId, Long movieId) {
        User userToUpdate = userRepository.findById(userId).orElse(null);
        if (userToUpdate != null) {
            Movie movie = movieRepository.findById(movieId).orElse(null);
            if (movie != null) {
                userToUpdate.getWatchedMovies().add(movie);
                userRepository.save(userToUpdate);
                return convertToDTO(userToUpdate);
            }
        }
        return null;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    private void updateEntity(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
    }
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return convertToDTO(user);
        }
        return null;
    }
    public List<MovieDTO> getWatchlistMovies(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<MovieDTO> watchlistMovies = new ArrayList<>();
        if (user != null) {
            List<Movie> watchlist = user.getWatchlist();
            for (Movie movie : watchlist) {
                MovieDTO movieDTO = new MovieDTO();
                movieDTO.setId(movie.getId());
                movieDTO.setName(movie.getName());
                watchlistMovies.add(movieDTO);
            }
        }
        return watchlistMovies;
    }




}
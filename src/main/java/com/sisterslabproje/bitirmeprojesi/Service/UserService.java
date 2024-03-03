package com.sisterslabproje.bitirmeprojesi.Service;

import com.sisterslabproje.bitirmeprojesi.Repository.UserRepository;
import com.sisterslabproje.bitirmeprojesi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found with id: " + userId));

        // Kullanıcı detaylarını güncelle
        user.setName(userDetails.getName());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        // Güncellenmiş kullanıcıyı kaydet ve döndür
        return userRepository.save(user);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }

}

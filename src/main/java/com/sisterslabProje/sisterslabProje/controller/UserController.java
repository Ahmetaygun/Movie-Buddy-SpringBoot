package com.sisterslabProje.sisterslabProje.controller;

import com.sisterslabProje.sisterslabProje.dto.UserDTO;
import com.sisterslabProje.sisterslabProje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO registeredUser = userService.registerUser(userDTO);
        if (registeredUser != null) {
            return ResponseEntity.ok("Kullanıcı başarıyla kaydedildi.");
        } else {
            return ResponseEntity.badRequest().body("Kullanıcı kaydedilirken bir hata oluştu.");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userId, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok("Kullanıcı başarıyla güncellendi.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Kullanıcı başarıyla silindi.");
    }

    @PutMapping("/update-password/{userId}")
    public ResponseEntity<String> changePassword(@PathVariable Long userId, @RequestBody String newPassword) {
        boolean passwordChanged = userService.changePassword(userId, newPassword);
        if (passwordChanged) {
            return ResponseEntity.ok("Şifre başarıyla değiştirildi.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
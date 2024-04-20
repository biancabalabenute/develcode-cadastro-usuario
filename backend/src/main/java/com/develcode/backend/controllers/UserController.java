package com.develcode.backend.controllers;

import com.develcode.backend.exceptions.UserNotFoundException;
import com.develcode.backend.models.User;
import com.develcode.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestParam("name") String name,
                                           @RequestParam("birthDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate birthDate,
                                           @RequestParam("image") MultipartFile file) throws IOException {
        User user = new User();
        user.setName(name);
        user.setBirthDate(birthDate);

        byte[] imageBytes = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        user.setImage(base64Image.getBytes());

        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        String base64Image = Base64.getEncoder().encodeToString(user.getImage());
        user.setImage(base64Image.getBytes());
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestParam("name") String name,
                                           @RequestParam("birthDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate birthDate,
                                           @RequestParam(value = "image", required = false) MultipartFile file) throws IOException {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(name);
                    user.setBirthDate(birthDate);
                    if (file != null && !file.isEmpty()) {
                        try {
                            user.setImage(file.getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    userRepository.save(user);
                    return ResponseEntity.ok(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "Usuario de id " + id + " foi deletado com sucesso.";
    }
}

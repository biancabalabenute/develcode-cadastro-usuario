package com.develcode.backend.controllers;

import com.develcode.backend.exceptions.UserNotFoundException;
import com.develcode.backend.models.User;
import com.develcode.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
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
        user.setImage(file.getBytes());
        userRepository.save(user);  // Salve o usuário no banco de dados
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setBirthDate(newUser.getBirthDate());
                    return userRepository.save(user);
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

package com.develcode.backend.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @InjectMocks
    private User user;

    @Mock
    private MultipartFile multipartFile;

    @Test
    void setImage_fromMultipartFile() throws IOException {
        byte[] imageBytes = "test image".getBytes();

        when(multipartFile.getBytes()).thenReturn(imageBytes);

        user.setImage(multipartFile);

        assertArrayEquals(imageBytes, user.getImage());
    }

    @Test
    void constructorAndGetters() {
        Long id = 1L;
        String name = "José";
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        byte[] imageBytes = "test image".getBytes();

        User newUser = new User(id, name, birthDate, imageBytes);

        assertEquals(id, newUser.getId());
        assertEquals(name, newUser.getName());
        assertEquals(birthDate, newUser.getBirthDate());
        assertArrayEquals(imageBytes, newUser.getImage());
    }

    @Test
    void settersAndGetters() {
        Long id = 1L;
        String name = "Maria";
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        byte[] imageBytes = "test image".getBytes();

        user.setId(id);
        user.setName(name);
        user.setBirthDate(birthDate);
        user.setImage(imageBytes);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(birthDate, user.getBirthDate());
        assertArrayEquals(imageBytes, user.getImage());
    }
}
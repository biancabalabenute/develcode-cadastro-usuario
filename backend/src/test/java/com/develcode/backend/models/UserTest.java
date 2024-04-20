package com.develcode.backend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testIdGetterAndSetter() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void testNameGetterAndSetter() {
        String name = "Jose da Silva";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    public void testBirthDateGetterAndSetter() {
        LocalDate birthDate = LocalDate.of(1997, 5, 15);
        user.setBirthDate(birthDate);
        assertEquals(birthDate, user.getBirthDate());
    }

    @Test
    public void testNoArgsConstructor() {
        User newUser = new User();
        assertNotNull(newUser);
    }

    @Test
    public void testAllArgsConstructor() {
        Long id = 1L;
        String name = "Maria Rodrigues";
        LocalDate birthDate = LocalDate.of(1985, 3, 20);
        User newUser = new User(id, name, birthDate);
        assertEquals(id, newUser.getId());
        assertEquals(name, newUser.getName());
        assertEquals(birthDate, newUser.getBirthDate());
    }
}
package com.example.authserver.service;

import com.example.authserver.dto.RegisterUserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {RegistrationService.class})
@ExtendWith(SpringExtension.class)
class RegistrationServiceTest {

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegistrationService registrationService;

    @MockBean
    private UserDetailsManager userDetailsManager;

    @Test
    void usernameAlreadyTakenTest() {

        // Arrange
        String expectedUsername = "janedoe";
        String expectedMessage = "Username already taken";
        HttpStatusCode expectedStatusCode = HttpStatusCode.valueOf(400);

        when(userDetailsManager.userExists(any())).thenReturn(true);

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setPassword("iloveyou");
        registerUserDto.setUsername(expectedUsername);

        // Act
        ResponseEntity<String> actualRegisterUserResult = registrationService.registerUser(registerUserDto);

        // Assert
        verify(userDetailsManager).userExists(any());
        assertEquals(expectedMessage, actualRegisterUserResult.getBody());
        assertEquals(expectedStatusCode, actualRegisterUserResult.getStatusCode());
        assertTrue(actualRegisterUserResult.getHeaders().isEmpty());

    }

    @Test
    void itShouldRegisterUserSuccessfully() {

        // Arrange
        String expectedPassword = "secret";
        String expectedUsername = "janedoe";
        HttpStatusCode expectedStatusCode = HttpStatusCode.valueOf(201);
        String expectedMessage = "User registered successfully";

        doNothing().when(userDetailsManager).createUser(any());
        when(userDetailsManager.userExists(any())).thenReturn(false);
        when(passwordEncoder.encode(any())).thenReturn(expectedPassword);

        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setPassword("iloveyou");
        registerUserDto.setUsername(expectedUsername);

        // Act
        ResponseEntity<String> actualRegisterUserResult = registrationService.registerUser(registerUserDto);

        // Assert
        verify(passwordEncoder).encode(any());
        verify(userDetailsManager).createUser(any());
        verify(userDetailsManager).userExists(any());

        assertEquals(expectedMessage, actualRegisterUserResult.getBody());
        assertEquals(expectedStatusCode, actualRegisterUserResult.getStatusCode());
        assertTrue(actualRegisterUserResult.getHeaders().isEmpty());
    }
}

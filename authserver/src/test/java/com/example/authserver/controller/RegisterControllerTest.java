package com.example.authserver.controller;

import com.example.authserver.dto.RegisterUserDto;
import com.example.authserver.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegisterController.class)
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService registrationService; // Mocked automatically by @MockBean

    @Test
    void itShouldRegisterUserSuccessfully() throws Exception {

        //Arrange
        given(registrationService.registerUser(any(RegisterUserDto.class))).willReturn(new ResponseEntity<>("User registered successfully", HttpStatus.CREATED));

        // Act
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"janedoe\",\"password\":\"iloveyou\"}")
                        .with(SecurityMockMvcRequestPostProcessors.user("janedoe").roles("USER"))
                        .with(csrf()))
        // Assert
                .andExpectAll(
                    status().isCreated(),
                    content().string("User registered successfully")
                );
    }
    @Test
    void itShouldNotWorkWithNullRegistrationService() {

        // Arrange
        String expectedUsername = "janedoe";
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setPassword("iloveyou");
        registerUserDto.setUsername(expectedUsername);

        when(registrationService.registerUser(any())).thenReturn(null);
        RegisterController registerController = new RegisterController(registrationService);

        // Act
        ResponseEntity<String> actualRegisterUserResult = registerController.registerUser(registerUserDto);

        // Assert
        verify(registrationService).registerUser(any());
        assertNull(actualRegisterUserResult);
    }
}

package com.example.authserver.service;

import com.example.authserver.dto.RegisterUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegistrationService {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> registerUser(RegisterUserDto registerUserDto)  {

        if(userDetailsManager.userExists(registerUserDto.getUsername())) {
            log.info("User with username {} already taken", registerUserDto.getUsername());
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }

        var userBuilder = User.builder().roles("USER");
        var newUser = userBuilder
                .username(registerUserDto.getUsername())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .build();

        userDetailsManager.createUser(newUser);
        log.info("User {} registered successfully", registerUserDto.getUsername());
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}

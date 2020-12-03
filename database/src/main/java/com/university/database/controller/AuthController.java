package com.university.database.controller;

import com.university.database.exception.PasswordsNotEqualsException;
import com.university.database.exception.UserAlreadyExistException;
import com.university.database.model.dao.UserRepo;
import com.university.database.model.dto.user.UserRegistrationDTO;
import com.university.database.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@EnableTransactionManagement
public class AuthController {

    @Value("${reroute.url}")
    private String rerouteURL;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ResponseEntity<String> getLogin() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(URI.create(rerouteURL + "/ui/login"));
        return
                ResponseEntity.status(HttpStatus.OK)
                        .headers(responseHeaders)
                        .body("");
    }


    @PostMapping("/registration")
    @Transactional
    public ResponseEntity<String> addUser(@Validated @RequestBody UserRegistrationDTO registrationDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (userRepo.findByEmail(registrationDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(registrationDto.toString());
        } else if (!registrationDto.getPassword().equals(registrationDto.getRepeatPassword())) {
            throw new PasswordsNotEqualsException("Passwords not equals");
        } else {
            User userFromDto = new User();
            userFromDto.setEmail(registrationDto.getEmail());
            userFromDto.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            userRepo.save(userFromDto);
        }
        responseHeaders.setLocation(URI.create(rerouteURL + "/ui/login"));
        return ResponseEntity.status(HttpStatus.OK)
                .headers(responseHeaders)
                .body("");
    }
}
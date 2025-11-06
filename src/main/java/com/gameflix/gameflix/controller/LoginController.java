package com.gameflix.gameflix.controller;

import com.gameflix.gameflix.model.LoginRequest;
import com.gameflix.gameflix.model.User;
import com.gameflix.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.registry.Registry;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            if (authentication.isAuthenticated()) {
                response.put("message", "Login successful");
                return response;
            } else {
                response.put("message", "Invalid username or password");
                return response;
            }
        } catch (AuthenticationException e) {
            System.out.println(e);
            response.put("message", "Invalid username or password");
            return response;
        }
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User request) {
        Map<String, Object> response = new HashMap<>();
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        try {
            userRepository.save(request);
            response.put("message", "User registered successfully");
            return response;
        } catch (DataIntegrityViolationException e) {
            response.put("message", "Username already exists");
            return response;
        }
    }
}


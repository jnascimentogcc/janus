package com.autoloan.security.controller;

import com.autoloan.security.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("${endpoint.prefix.api-v1}/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        return authService.attemptLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
package com.autoloan.security.service;

import com.autoloan.security.config.JwtIssuer;
import com.autoloan.security.config.UserPrincipal;
import com.autoloan.security.controller.LoginResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;

    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        List<String> listAuthorities = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String jwtToken = jwtIssuer.issue(userPrincipal.getId(), userPrincipal.getEmail(), listAuthorities);
        return LoginResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}
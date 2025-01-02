package com.autoloan.security.config;

import com.autoloan.security.model.UserEntity;
import com.autoloan.security.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(username).orElseThrow();
        return UserPrincipal.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .authorities(List.of(new SimpleGrantedAuthority(userEntity.getRole())))
                .password(userEntity.getPassword())
                .build();
    }
}
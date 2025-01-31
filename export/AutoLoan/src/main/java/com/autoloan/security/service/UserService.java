package com.autoloan.security.service;

import com.autoloan.security.model.UserEntity;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    // TODO: Move this to user Provider (DB or another component)
    private static final String EXISTING_EMAIL = "admin@janus.com";

    private static final String ANOTHER_EMAIL = "user@janus.com";

    public Optional<UserEntity> findByEmail(String email) {

        if (EXISTING_EMAIL.equals(email)) {
            UserEntity user = new UserEntity();
            user.setId(UUID.randomUUID().toString());
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$10SJ8DZ7sTRc9wcrMuAyTuK2BPbRKbiizHCttiOUOJkzmYT7wSQH."); // test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("This is an admin user");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equals(email)) {
            UserEntity user = new UserEntity();
            user.setId(UUID.randomUUID().toString());
            user.setEmail(ANOTHER_EMAIL);
            user.setPassword("$2a$12$10SJ8DZ7sTRc9wcrMuAyTuK2BPbRKbiizHCttiOUOJkzmYT7wSQH."); // test
            user.setRole("ROLE_ALL_CUSTOMER");
            user.setExtraInfo("This is a user");
            return Optional.of(user);
        }

        return Optional.empty();
    }
}
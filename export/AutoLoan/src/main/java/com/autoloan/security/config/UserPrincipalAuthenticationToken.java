package com.autoloan.security.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Objects;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {

    private final UserPrincipal userPrincipal;

    public UserPrincipalAuthenticationToken(UserPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        this.userPrincipal = userPrincipal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return this.userPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserPrincipalAuthenticationToken that = (UserPrincipalAuthenticationToken) o;
        return Objects.equals(userPrincipal, that.userPrincipal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userPrincipal);
    }
}
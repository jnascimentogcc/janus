package com.autoloan.security.config;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT decodedJWT ) {
        return UserPrincipal.builder()
                .id(decodedJWT.getSubject())
                .email(decodedJWT.getClaim("e").asString())
                .authorities(this.extractAuthoritiesFromClaim(decodedJWT))
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT decodedJWT) {
        Claim roles = decodedJWT.getClaim("a");
        if (roles.isNull() || roles.isMissing()) return List.of();
        return roles.asList(SimpleGrantedAuthority.class);
    }
}
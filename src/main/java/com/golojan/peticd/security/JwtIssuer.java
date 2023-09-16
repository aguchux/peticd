package com.golojan.peticd.security;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {

    private final JwtProperties properties;

    public String issueToken(long userId,  String email, List<String> roles){
        Instant value = Instant.now().plus(Duration.of(30, ChronoUnit.DAYS));
        return JWT.create()
        .withSubject(String.valueOf(userId))
        .withExpiresAt( java.util.Date.from(value) )
        .withClaim("email", email)
        .withArrayClaim("roles", roles.toArray(new String[0]))
        .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}

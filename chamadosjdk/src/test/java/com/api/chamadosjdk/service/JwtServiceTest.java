package com.api.chamadosjdk.service;

import com.api.chamadosjdk.config.JwtProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do JwtService")
class JwtServiceTest {

    private JwtService jwtService;
    private JwtProperties jwtProperties;

    @BeforeEach
    void setUp() {
        jwtProperties = new JwtProperties();
        jwtProperties.setSecret("mySecretKey12345678901234567890123456789012");
        jwtProperties.setExpiration(86400000); // 24h

        jwtService = new JwtService();
        // 👇 Injeta no campo privado usando reflexão
        ReflectionTestUtils.setField(jwtService, "jwtProperties", jwtProperties);
    }

    @Test
    @DisplayName("Deve gerar token JWT válido")
    void deveGerarTokenValido() {
        String username = "admin";
        String token = jwtService.generateToken(username);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    @DisplayName("Deve extrair username do token")
    void deveExtrairUsernameDoToken() {
        String username = "admin";
        String token = jwtService.generateToken(username);
        String extractedUsername = jwtService.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    @DisplayName("Deve validar token válido")
    void deveValidarTokenValido() {
        String username = "admin";
        String token = jwtService.generateToken(username);
        UserDetails userDetails = new User(username, "password", Collections.emptyList());
        assertTrue(jwtService.validateToken(token, userDetails));
    }

    @Test
    @DisplayName("Deve rejeitar token expirado")
    void deveRejeitarTokenExpirado() throws InterruptedException {
        jwtProperties.setExpiration(1); // 1ms
        ReflectionTestUtils.setField(jwtService, "jwtProperties", jwtProperties);

        String username = "admin";
        String token = jwtService.generateToken(username);

        Thread.sleep(10); // garantir expiração

        UserDetails userDetails = new User(username, "password", Collections.emptyList());
        assertFalse(jwtService.validateToken(token, userDetails));
    }
}
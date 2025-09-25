package br.com.UrbanSwift.UrbanSwift.controller;

import br.com.UrbanSwift.UrbanSwift.dto.loginRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
@RequestMapping("/api/login")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    public LoginController(AuthenticationManager authenticationManager, JwtEncoder jwtEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtEncoder = jwtEncoder;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody loginRequest login) {
        var authToken = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha());
            Authentication auth = authenticationManager.authenticate(authToken);
        Instant now = Instant.now();
        long validade = 3600L; // 1 Hora em segundos.
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("urbanswift-api") // Quem emitiu o token.
                .issuedAt(now) // Quando foi emitido.
                .expiresAt(now.plusSeconds(validade)) // Quando expira.
                .subject(auth.getName()) // A quem o token pertence (o email do usuário).
                .claim("roles", auth.getAuthorities()) // Informações extras, como os perfis do usuário.
                .build();

        // 6. Define o cabeçalho do token, especificando o algoritmo de assinatura.
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();

        // 7. Usa a "Máquina de Criar Tokens" para gerar a string final, combinando o cabeçalho
        // e o payload, e assinando tudo com nossa chave secreta.
        String token = this.jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();

        // 8. Retorna o token gerado para o cliente com um status 200 OK.
        return ResponseEntity.ok(token);
    }
}

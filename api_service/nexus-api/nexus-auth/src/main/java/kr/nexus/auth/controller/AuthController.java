package kr.nexus.auth.controller;

import kr.nexus.auth.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);
        boolean isValid = jwtTokenProvider.validateToken(token);

        if (isValid) {
            String username = jwtTokenProvider.getUsername(token);
            Map<String, Object> response = new HashMap<>();
            response.put("valid", true);
            response.put("username", username);
            // In a real app, you might return roles, user ID, etc.
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(Map.of("valid", false));
        }
    }
    
    // For demo purposes, a login endpoint to get a token
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        // Simple mock authentication
        String token = jwtTokenProvider.createToken(username);
        return ResponseEntity.ok(Map.of("token", token));
    }
}

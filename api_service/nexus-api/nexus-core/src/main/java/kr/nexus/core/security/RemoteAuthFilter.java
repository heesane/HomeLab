package kr.nexus.core.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@Slf4j
public class RemoteAuthFilter extends OncePerRequestFilter {

    private final String authServiceUrl;
    private final RestTemplate restTemplate;

    public RemoteAuthFilter(String authServiceUrl) {
        this.authServiceUrl = authServiceUrl;
        this.restTemplate = new RestTemplate();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", authHeader);
                HttpEntity<Void> entity = new HttpEntity<>(headers);

                ResponseEntity<Map<String, Object>> authResponse = restTemplate.exchange(
                        authServiceUrl + "/api/auth/validate",
                        HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<Map<String, Object>>() {}
                );

                if (authResponse.getStatusCode().is2xxSuccessful() && authResponse.getBody() != null) {
                    Map<String, Object> body = authResponse.getBody();
                    if (Boolean.TRUE.equals(body.get("valid"))) {
                        String username = (String) body.get("username");
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                                username, null, Collections.emptyList());
                        SecurityContextHolder.getContext().setAuthentication(auth);
                        log.debug("Remote authentication successful for user: {}", username);
                    }
                }
            } catch (Exception e) {
                log.error("Auth service call failed: {}", e.getMessage());
                // In a production app, you might want to handle specific status codes (401, etc.)
            }
        }

        filterChain.doFilter(request, response);
    }
}

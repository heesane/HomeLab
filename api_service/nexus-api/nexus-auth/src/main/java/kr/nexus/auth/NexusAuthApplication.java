package kr.nexus.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus Authentication Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.auth", "kr.nexus.core", "kr.nexus.domain"})
public class NexusAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusAuthApplication.class, args);
    }
}

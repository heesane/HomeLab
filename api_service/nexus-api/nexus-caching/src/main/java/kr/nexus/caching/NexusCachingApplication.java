package kr.nexus.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus Caching Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.caching", "kr.nexus.core", "kr.nexus.domain"})
public class NexusCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusCachingApplication.class, args);
    }
}

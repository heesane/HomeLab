package kr.nexus.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus Image Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.image", "kr.nexus.core", "kr.nexus.domain"})
public class NexusImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusImageApplication.class, args);
    }
}

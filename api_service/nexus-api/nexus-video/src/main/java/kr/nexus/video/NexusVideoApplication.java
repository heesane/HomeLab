package kr.nexus.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus Video Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.video", "kr.nexus.core", "kr.nexus.domain"})
public class NexusVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusVideoApplication.class, args);
    }
}

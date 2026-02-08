package kr.nexus.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus Document Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.document", "kr.nexus.core", "kr.nexus.domain"})
public class NexusDocumentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusDocumentApplication.class, args);
    }
}

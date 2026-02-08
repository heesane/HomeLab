package kr.nexus.rdbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Nexus RDBMS Service.
 */
@SpringBootApplication(scanBasePackages = {"kr.nexus.rdbms", "kr.nexus.core", "kr.nexus.domain"})
public class NexusRdbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusRdbmsApplication.class, args);
    }
}

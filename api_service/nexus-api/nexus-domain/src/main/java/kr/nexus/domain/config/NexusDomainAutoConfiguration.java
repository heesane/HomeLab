package kr.nexus.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Auto-configuration for Nexus Domain module.
 */
@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = "kr.nexus.domain")
public class NexusDomainAutoConfiguration {
}

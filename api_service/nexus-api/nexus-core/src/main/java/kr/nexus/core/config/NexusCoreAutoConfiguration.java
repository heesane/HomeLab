package kr.nexus.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration for Nexus Core module.
 */
@Configuration
@ComponentScan(basePackages = "kr.nexus.core")
public class NexusCoreAutoConfiguration {
}

package kr.nexus.core.exception;

import lombok.Getter;

/**
 * Base exception class for all Nexus application exceptions.
 * Provides a foundation for the exception hierarchy following SOLID principles.
 */
@Getter
public class NexusException extends RuntimeException {

    private final String errorCode;

    public NexusException(String message) {
        super(message);
        this.errorCode = "NEXUS_ERROR";
    }

    public NexusException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public NexusException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}

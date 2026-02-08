package kr.nexus.core.exception;

/**
 * Exception for business logic violations.
 */
public class BusinessException extends NexusException {

    public BusinessException(String message) {
        super("BUSINESS_ERROR", message);
    }

    public BusinessException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}

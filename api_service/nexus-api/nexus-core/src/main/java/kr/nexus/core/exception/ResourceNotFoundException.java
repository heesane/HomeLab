package kr.nexus.core.exception;

/**
 * Exception thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends NexusException {

    public ResourceNotFoundException(String message) {
        super("RESOURCE_NOT_FOUND", message);
    }

    public ResourceNotFoundException(String resourceType, Object identifier) {
        super("RESOURCE_NOT_FOUND", 
              String.format("%s not found with identifier: %s", resourceType, identifier));
    }

    public ResourceNotFoundException(String errorCode, String message) {
        super(errorCode, message);
    }
}

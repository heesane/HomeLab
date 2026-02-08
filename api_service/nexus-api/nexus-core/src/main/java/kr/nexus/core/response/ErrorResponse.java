package kr.nexus.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Standard error response structure for consistent error formatting.
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String errorCode;
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private List<FieldError> fieldErrors;

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FieldError {
        private String field;
        private String message;
        private Object rejectedValue;
    }

    public static ErrorResponse of(String errorCode, String message, String path) {
        return ErrorResponse.builder()
                .errorCode(errorCode)
                .message(message)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ErrorResponse of(String errorCode, String message, String path, List<FieldError> fieldErrors) {
        return ErrorResponse.builder()
                .errorCode(errorCode)
                .message(message)
                .path(path)
                .timestamp(LocalDateTime.now())
                .fieldErrors(fieldErrors)
                .build();
    }
}

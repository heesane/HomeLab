package kr.nexus.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Standard pagination request DTO.
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequest {

    @Min(value = 0, message = "Page number must be non-negative")
    @Builder.Default
    private int page = 0;

    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size must not exceed 100")
    @Builder.Default
    private int size = 20;

    @Builder.Default
    private String sortBy = "createdAt";

    @Builder.Default
    private SortDirection sortDirection = SortDirection.DESC;

    public enum SortDirection {
        ASC, DESC
    }

    public org.springframework.data.domain.PageRequest toPageable() {
        org.springframework.data.domain.Sort sort = sortDirection == SortDirection.ASC
                ? org.springframework.data.domain.Sort.by(sortBy).ascending()
                : org.springframework.data.domain.Sort.by(sortBy).descending();
        return org.springframework.data.domain.PageRequest.of(page, size, sort);
    }
}

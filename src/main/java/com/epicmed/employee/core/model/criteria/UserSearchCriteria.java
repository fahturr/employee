package com.epicmed.employee.core.model.criteria;

import jakarta.validation.constraints.Min;
import lombok.Builder;

@Builder
public record UserSearchCriteria(
    @Min(value = 1)
    int page,
    @Min(value = 1)
    int size
) {
}

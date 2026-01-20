package com.epicmed.employee.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class Paged<T> {

    private final List<T> data;
    private final Metadata metadata;

    @Builder
    public record Metadata(
        int page,
        int limit,
        int totalItem
    ) {

        public int totalPage() {
            return (int) Math.ceil((double) totalItem / limit);
        }

    }

}

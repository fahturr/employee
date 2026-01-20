package com.epicmed.employee.api.dto;

import com.epicmed.employee.core.model.Paged;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PagedApiResponse<T> {
    private final int page;
    private final int size;
    private final int totalItems;
    private final int totalPages;
    private final List<T> data;

    @Builder
    public PagedApiResponse(List<T> data, Paged.Metadata metadata) {
        this.data = data;
        this.page = metadata.page();
        this.size = metadata.limit();
        this.totalItems = metadata.totalItem();
        this.totalPages = metadata.totalPage();
    }

}

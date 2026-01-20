package com.epicmed.employee.api.mapper;

import com.epicmed.employee.api.dto.PagedApiResponse;
import com.epicmed.employee.core.model.Paged;

public interface DefaultMapper {

    PagedApiResponse<Object> fromMetaData(Paged.Metadata metadata);

}

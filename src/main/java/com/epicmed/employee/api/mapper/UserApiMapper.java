package com.epicmed.employee.api.mapper;

import com.epicmed.employee.api.dto.response.ListUserResponse;
import com.epicmed.employee.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper extends DefaultMapper{

    ListUserResponse fromUserModel(User user);

}

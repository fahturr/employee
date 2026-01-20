package com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.mapper;

import com.epicmed.employee.core.model.User;
import com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserProfileToModel(UserResponse.UserProfile userProfile);

}

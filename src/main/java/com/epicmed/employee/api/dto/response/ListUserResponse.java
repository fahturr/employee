package com.epicmed.employee.api.dto.response;

public record ListUserResponse(
    int id,
    String firstName,
    String lastName,
    String email
) {
}

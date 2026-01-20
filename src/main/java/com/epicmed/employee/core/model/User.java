package com.epicmed.employee.core.model;

public record User(
    int id,
    String firstName,
    String lastName,
    int age,
    String email
) {
}

package com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.dto.response;

import java.util.List;

public record UserResponse(
    List<UserProfile> users,
    int total,
    int skip,
    int limit
) {

    public record UserProfile(
        Long id,
        String firstName,
        String lastName,
        String maidenName,
        Integer age,
        String gender,
        String email,
        String phone,
        String username,
        String password,
        String birthDate,
        String image,
        String bloodGroup,
        Double height,
        Double weight,
        String eyeColor,
        Hair hair,
        String ip,
        Address address,
        String macAddress,
        String university,
        Bank bank,
        Company company,
        String ein,
        String ssn,
        String userAgent,
        Crypto crypto,
        String role
    ) {
    }

    public record Coordinates(
        Double lat,
        Double lng
    ) {
    }

    public record Address(
        String address,
        String city,
        String state,
        String stateCode,
        String postalCode,
        Coordinates coordinates,
        String country
    ) {
    }

    public record Hair(
        String color,
        String type
    ) {
    }

    public record Bank(
        String cardExpire,
        String cardNumber,
        String cardType,
        String currency,
        String iban
    ) {
    }

    public record Company(
        String department,
        String name,
        String title,
        Address address
    ) {
    }

    public record Crypto(
        String coin,
        String wallet,
        String network
    ) {
    }

}

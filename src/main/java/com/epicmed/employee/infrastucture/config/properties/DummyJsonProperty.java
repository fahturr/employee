package com.epicmed.employee.infrastucture.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.external.integration.dummyjson")
public record DummyJsonProperty(
    String baseUrl,
    Integer connectTimeout
) {
}

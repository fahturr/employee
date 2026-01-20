package com.epicmed.employee.infrastucture.config;

import com.epicmed.employee.infrastucture.config.properties.DummyJsonProperty;
import io.netty.channel.ChannelOption;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@EnableConfigurationProperties(value = DummyJsonProperty.class)
@RequiredArgsConstructor
public class WebClientConfig {

    private final DummyJsonProperty dummyJsonProperty;

    @Bean
    public WebClient dummyJsonClient(WebClient.Builder builder) {
        var httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, dummyJsonProperty.connectTimeout());

        return builder
            .baseUrl(dummyJsonProperty.baseUrl())
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();
    }

}

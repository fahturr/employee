package com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.impl;

import com.epicmed.employee.core.model.Paged;
import com.epicmed.employee.core.model.User;
import com.epicmed.employee.core.model.criteria.UserSearchCriteria;
import com.epicmed.employee.core.repository.UserRepository;
import com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.dto.response.UserResponse;
import com.epicmed.employee.infrastucture.adapter.thirdparty.dummyjson.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
@RequiredArgsConstructor
public class DummyJsonAdapter implements UserRepository {

    private final WebClient dummyJsonClient;
    private final UserMapper userMapper;

    @Override
    public Paged<User> findAll(UserSearchCriteria criteria) {
        return dummyJsonClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/user")
                .queryParam("limit", criteria.size())
                .queryParam("skip", (criteria.page() - 1) * criteria.size())
                .build()
            )
            .retrieve()
            .bodyToMono(UserResponse.class)
            .map(res -> {
                var data = res.users()
                    .stream()
                    .map(userMapper::fromUserProfileToModel)
                    .toList();

                var metadata = Paged.Metadata.builder()
                    .page(criteria.page())
                    .limit(res.limit())
                    .totalItem(res.total())
                    .build();

                return Paged.<User>builder()
                    .data(data)
                    .metadata(metadata)
                    .build();
            })
            .block();
    }

}

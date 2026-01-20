package com.epicmed.employee.api.controller;

import com.epicmed.employee.api.dto.PagedApiResponse;
import com.epicmed.employee.api.dto.response.ListUserResponse;
import com.epicmed.employee.api.mapper.UserApiMapper;
import com.epicmed.employee.core.model.criteria.UserSearchCriteria;
import com.epicmed.employee.core.service.PagedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserApiMapper userApiMapper;
    private final PagedUserService listUserService;

    @GetMapping("/users")
    public PagedApiResponse<ListUserResponse> getListUser(
        @RequestParam(name = "page", defaultValue = "1") int page,
        @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        var response = listUserService.execute(
            UserSearchCriteria.builder()
                .size(size)
                .page(page)
                .build()
        );

        var data = response.getData()
            .stream()
            .map(userApiMapper::fromUserModel)
            .toList();

        return PagedApiResponse.<ListUserResponse>builder()
            .data(data)
            .metadata(response.getMetadata())
            .build();
    }

}

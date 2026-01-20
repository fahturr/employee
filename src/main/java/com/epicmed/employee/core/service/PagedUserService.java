package com.epicmed.employee.core.service;

import com.epicmed.employee.api.exception.BusinessException;
import com.epicmed.employee.core.model.Paged;
import com.epicmed.employee.core.model.User;
import com.epicmed.employee.core.model.criteria.UserSearchCriteria;
import com.epicmed.employee.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
public class PagedUserService {

    private final UserRepository userRepository;

    public Paged<User> execute(@Validated UserSearchCriteria criteria) {
        Paged<User> users = userRepository.findAll(criteria);

        if (users.getData().isEmpty()) {
            throw new BusinessException("List user is empty");
        }

        return users;
    }

}

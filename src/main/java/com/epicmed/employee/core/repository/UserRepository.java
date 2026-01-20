package com.epicmed.employee.core.repository;

import com.epicmed.employee.core.model.Paged;
import com.epicmed.employee.core.model.User;
import com.epicmed.employee.core.model.criteria.UserSearchCriteria;

public interface UserRepository {
    Paged<User> findAll(UserSearchCriteria criteria);
}

package com.app.educator.service;

import com.app.educator.dto.UserDto;
import com.app.educator.dto.UserProj;
import com.app.educator.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<UserDto> getAll();
    User getUser(Long id);
    User updateUser(User user, Long id);
    Boolean deleteUser(Long id);
    Page<UserProj> pagination(int currentPage, int pageSize);
}

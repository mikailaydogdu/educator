package com.app.educator.Mapper;

import com.app.educator.dto.UserDto;
import com.app.educator.entity.User;


public interface UserMapper {
    User map(UserDto userDto);
    UserDto map(User user);
}

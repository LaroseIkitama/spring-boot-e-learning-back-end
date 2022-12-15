package com.yekola.yekola_api_course.mapper;

import com.yekola.yekola_api_course.domain.User;
import com.yekola.yekola_api_course.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toUser(UserEntity userEntity);

    UserEntity fromUser(User user);
}

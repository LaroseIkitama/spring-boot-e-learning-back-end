package com.yekola.yekola_api_course.repository;

import com.yekola.yekola_api_course.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}

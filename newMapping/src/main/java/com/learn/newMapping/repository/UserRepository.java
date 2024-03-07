package com.learn.newMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.newMapping.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

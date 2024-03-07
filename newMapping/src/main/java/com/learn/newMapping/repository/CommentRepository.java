package com.learn.newMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.newMapping.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}

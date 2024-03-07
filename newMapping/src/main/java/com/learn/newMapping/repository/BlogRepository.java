package com.learn.newMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.newMapping.entity.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}

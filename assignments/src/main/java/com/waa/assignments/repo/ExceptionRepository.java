package com.waa.assignments.repo;

import com.waa.assignments.entity.business.ExceptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<ExceptionEntity, Long> {
}

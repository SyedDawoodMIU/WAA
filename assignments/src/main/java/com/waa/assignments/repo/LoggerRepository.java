package com.waa.assignments.repo;

import com.waa.assignments.entity.business.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}

package com.waa.assignments.aspect;

import com.waa.assignments.entity.business.ExceptionEntity;
import com.waa.assignments.repo.ExceptionRepository;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Aspect
@Component
public class ExceptionAspect {

    @Autowired
    private ExceptionRepository exceptionRepository;

    @AfterThrowing(pointcut = "execution(* *..*Service.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setPrinciple("user");
        exceptionEntity.setDate(LocalDateTime.now());
        exceptionEntity.setOperation(ex.getStackTrace()[0].toString());
        exceptionEntity.setException(ex.getClass().getName());
        exceptionRepository.save(exceptionEntity);
    }
}

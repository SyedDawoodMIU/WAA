package com.waa.assignments.aspect;

import com.waa.assignments.entity.business.Logger;
import com.waa.assignments.repo.LoggerRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private LoggerRepository loggerRepository;

    @Around("@annotation(com.waa.assignments.aspect.annotation.ExecutionTime)")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println("Time Taken by " + pjp.getSignature() + " is " + timeTaken + "ms");

        Logger logger = new Logger();
        logger.setPrinciple("My user");
        logger.setDate(LocalDateTime.now());
        logger.setOperation(pjp.getSignature().toString());
        loggerRepository.save(logger);

        return obj;
    }
}

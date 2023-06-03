package com.example.mockexam1.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(public List<Student> com.example.mockexam1.controller.*(..))")
    private void listReturningMethodStudentController() {}


    @AfterReturning(
            pointcut = "listReturningMethodStudentController()",
            returning= "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result){
        sendAlert(joinPoint);
    }

    public void sendAlert(JoinPoint joinPoint) {
        // implementation to send alert
    }
}
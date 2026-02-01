package ru.edu.taskmanagementsystem.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public * ru.edu.taskmanagementsystem.service..*(..))")
    public void anyServicePublicMethod() {
    }

    @Pointcut("execution(public * ru.edu.taskmanagementsystem.service..get*(..)) || " +
            "execution(public * ru.edu.taskmanagementsystem.service..set*(..))")
    public void gettersAndSetters() {
    }

    @Pointcut("anyServicePublicMethod() && !gettersAndSetters()")
    public void businessMethods() {
    }

    @Pointcut("@annotation(ru.edu.taskmanagementsystem.aop.annotations.Audited)")
    public void auditedMethods() {
    }

    @Before("businessMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("[LOG] Calling " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.println("      args: " + Arrays.toString(args));
        }
    }

    @AfterReturning(pointcut = "businessMethods()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] " + joinPoint.getSignature().toShortString() +
                " returned: " + result);
    }

    @AfterThrowing(pointcut = "businessMethods()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[LOG] " + joinPoint.getSignature().toShortString() +
                " threw exception: " + ex.getClass().getSimpleName() +
                " - " + ex.getMessage());
    }

    @Before("auditedMethods()")
    public void audit(JoinPoint joinPoint) {
        System.out.println("[AUDIT] " + joinPoint.getSignature().toShortString());
    }
}


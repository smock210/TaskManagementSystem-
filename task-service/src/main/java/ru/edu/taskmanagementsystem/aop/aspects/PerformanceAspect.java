package ru.edu.taskmanagementsystem.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(public * ru.edu.taskmanagementsystem.service..*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            return pjp.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;
            System.out.println(
                    "[PERF] " +
                            pjp.getSignature().toShortString() +
                            " executed in " +
                            duration + " ms"
            );
        }
    }
}

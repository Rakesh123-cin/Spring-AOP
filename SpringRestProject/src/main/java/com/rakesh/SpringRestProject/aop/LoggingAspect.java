package com.rakesh.SpringRestProject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // @Before("execution(return_type absolute_class_name.method_name(args))")
    @Before("execution(* com.rakesh.SpringRestProject.service.JobService.*(..))")
    public void logMethodCall()
    {
        LOGGER.info("Method Called");
    }

    @Before("execution(* com.rakesh.SpringRestProject.service.JobService.getJob(..)) || execution(* com.rakesh.SpringRestProject.service.JobService.getAllJobs(..))")
    public void logSpecificMethodCall(JoinPoint jp)
    {
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }

    @After("execution(* com.rakesh.SpringRestProject.service.JobService.getJob(..)) || execution(* com.rakesh.SpringRestProject.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp)
    {
        LOGGER.info("Method executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.rakesh.SpringRestProject.service.JobService.getJob(..)) || execution(* com.rakesh.SpringRestProject.service.JobService.getAllJobs(..))")
    public void logMethodCrashed(JoinPoint jp)
    {
        LOGGER.info("Method Crashed "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.rakesh.SpringRestProject.service.JobService.getJob(..)) || execution(* com.rakesh.SpringRestProject.service.JobService.getAllJobs(..))")
    public void logMethodExecutedSuccessfully(JoinPoint jp)
    {
        LOGGER.info("Method executed successfully "+jp.getSignature().getName());
    }
}

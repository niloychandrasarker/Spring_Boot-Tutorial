package com.devrezaur.main;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspect {
	
	Logger logger = LoggerFactory.getLogger(AopAspect.class);

    @Before("execution(* AopClass+.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("**** Staring - " + joinPoint.getSignature().getName());
		logger.info("**** With parameter - " + Arrays.toString(joinPoint.getArgs()));
	}
    
//    @After("execution(* AopClass+.*(..))")
//	public void after(JoinPoint joinPoint) {
//		logger.info("**** Finished - " + joinPoint.getSignature().getName());
//	}
    
  @AfterReturning(value="execution(* AopClass+.*(..))", returning="result")
	public void after(JoinPoint joinPoint, Object result) {
		logger.info("**** Finished - " + joinPoint.getSignature().getName());
		logger.info("**** Returned - " + result);
	}
}

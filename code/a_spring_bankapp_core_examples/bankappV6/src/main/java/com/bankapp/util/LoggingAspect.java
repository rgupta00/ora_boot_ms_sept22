package com.bankapp.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	//@Before @After  @AfterReturing @Around @AfterThrowing (logging ..)
	
//	@Around("execution(public void transfer(..))")
//	@Around("execution( * com.bankapp.service.*.*(..))")
	@Around("@annotation(MyLogging)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object result= joinPoint.proceed();
		
		long end = System.currentTimeMillis();

		String methodName= joinPoint.getSignature().getName();
		
		logger.info(methodName+" method take " + (end - start) + " ms to executed");
		
		return result;
	}
	
//	@AfterThrowing(pointcut = "execution( * com.bankapp.service.*.*(..))", throwing = "e")
//	public void logginExceptions(Exception e) throws Throwable {
//		System.out.println("---------------------------------------------");
//		logger.error(e.toString());
//	}
}






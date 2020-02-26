package com.zaju.ticketreservationapi.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LogManager.getLogger();

	@Around("execution(* com.zaju.ticketreservationapi.service.*.*(..))")
	public Object logServiceOperations(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object returnValue;

		try {
			returnValue = proceedingJoinPoint.proceed();
			
			logInfo(proceedingJoinPoint);
		} catch (Exception e) {
			logError(proceedingJoinPoint, e);
			throw e;
		}

		return returnValue;
	}
	
	private void logInfo(ProceedingJoinPoint proceedingJoinPoint) {
		LOGGER.info(buildMessage(proceedingJoinPoint));
	}
	
	private void logError(ProceedingJoinPoint proceedingJoinPoint, Exception e) {
		LOGGER.error(buildMessage(proceedingJoinPoint) + e.getMessage());
	}
	
	private String buildMessage(ProceedingJoinPoint proceedingJoinPoint) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(proceedingJoinPoint.getSignature().getDeclaringTypeName());
		sb.append(".");
		sb.append(proceedingJoinPoint.getSignature().getName());
		sb.append(" params = ");
		sb.append(Arrays.toString(proceedingJoinPoint.getArgs()));
		sb.append(" ");
		
		return sb.toString();
	}

}

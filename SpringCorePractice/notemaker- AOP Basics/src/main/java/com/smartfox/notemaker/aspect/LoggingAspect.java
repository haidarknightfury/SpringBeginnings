package com.smartfox.notemaker.aspect;

import java.util.Arrays;
import java.util.Collection;import javax.sound.midi.ControllerEventListener;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	/**
	 * JoinPoint -> the target 
	 * PointCut- > expression that recognises the joinpoint through regExp 
	 * Advice -> Code executed at joinpoint recognised by the pointcut 
	 * Aspect -> contains all the joinpoints
	 */
	
	
	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {

	}

	/**
	 * My Advice
	 * 
	 * @param joinpoint
	 */
	@Before("executeLogging()")
	public void logMethodCall(JoinPoint joinpoint) {
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		if (null != args && args.length != 0) {
			message.append("args");
			Arrays.asList(args).forEach(arg -> {
				message.append(arg);
			});
		}
		
		System.out.println(message.toString());
	}
	
	
	@AfterReturning(pointcut="executeLogging()", returning = "returnValue")
	public void afterReturn(JoinPoint joinpoint, Object returnValue) {
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinpoint.getSignature().getName());
		Object[] args = joinpoint.getArgs();
		if (null != args && args.length != 0) {
			message.append("args");
			Arrays.asList(args).forEach(arg -> {
				message.append(arg);
			});
		}
		
		if(returnValue instanceof Collection) {
			message.append(((Collection) returnValue).size());
		}
		else {
			message.append(returnValue.toString());
		}
		
		System.out.println(message.toString());
	}
	
	
	
	@Around("executeLogging()")
	public Object aroundAdvice(ProceedingJoinPoint joinpoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		// tell jointput to continue
		Object returnValue = joinpoint.proceed();
		long total = System.currentTimeMillis() - startTime;
		
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinpoint.getSignature().getName());
		message.append("totalTime : ").append(total);
		Object[] args = joinpoint.getArgs();
		if (null != args && args.length != 0) {
			message.append("args");
			Arrays.asList(args).forEach(arg -> {
				message.append(arg);
			});
		}
		
		if(returnValue instanceof Collection) {
			message.append(((Collection) returnValue).size());
		}
		else {
			message.append(returnValue.toString());
		}
		
		System.out.println(message.toString());
		return returnValue;
	}
	
	
	
	
	
	
	
	
	
	
	
}

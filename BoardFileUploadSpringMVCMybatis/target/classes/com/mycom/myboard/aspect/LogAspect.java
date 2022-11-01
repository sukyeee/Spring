package com.mycom.myboard.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut(value="execution( * com.mycom.myboard..*(..) )")
	private void logPointcut() {}
	
	
	@Before("logPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signatre = joinPoint.getSignature();
		logger.debug("[Logger : Before] 메소드 이름 : " +  signatre.getName());
	}
	
	@After("logPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature signatre = joinPoint.getSignature();
		logger.info("[Logger : After] 메소드 이름 : " +  signatre.getName());
	}
}

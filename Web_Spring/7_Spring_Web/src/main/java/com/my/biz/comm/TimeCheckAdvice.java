package com.my.biz.comm;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class TimeCheckAdvice {
	Logger logger = Logger.getLogger("myApp");
	
	//@Pointcut("execution(* com.my.biz.user.service.UserService.*(..))")
	public void allPoint() {}
	
	//@Pointcut("execution(* com.my.biz.user.service.UserService.login(..))")
		public void point2(){}
	
	@Around("com.my.biz.comm.AnnotAdvice.point2()")
	public Object check(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("*** log_around start. ***");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		String msg = pjp.getSignature().getName() + "() 수행에 걸린 시간 : "
				+ stopWatch.getTotalTimeMillis()+"(ms)초";
		logger.info(msg);
		System.out.println("*** log_around stop. ***");
		return obj;
	}
	
}

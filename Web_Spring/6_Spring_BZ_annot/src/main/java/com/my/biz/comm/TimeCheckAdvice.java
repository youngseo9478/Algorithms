package com.my.biz.comm;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCheckAdvice {

	Logger logger = Logger.getLogger("myApp");

	// @Pointcut("execution(* com.my.biz.user.service.UserService.login(..))")
	// public void point2() {
	// } 
	//아래 @around안에 풀패키지 명을 적어주면 외부에있는 메소드를 끌어다 실행시킬 수 있다.

	@Around("com.my.biz.comm.AnnotAdvice.point2()")
	public Object log_around(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("*** log_around start. ****");
		long start = System.currentTimeMillis();
		Object obj = pp.proceed();
		long end = System.currentTimeMillis();
		String msg = pp.getSignature().getName() + "수행소요시간 : " + (end - start);
		// System.out.println(msg);
		logger.info(msg);
		System.out.println("*** log_around stop. ****");
		return obj;
	}
}

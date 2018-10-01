package com.my.biz.comm;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class AnnotAdvice {
	
	@Pointcut("execution(* com.my.biz.user.service.UserService.get*(..))")
	public void point1() {}
	
	@Pointcut("execution(* com.my.biz.user.service.UserService.login(..))")
	public void point2() {}
	
	@Before("point1()")
	public void log(JoinPoint jp) {// JoinPoint
		System.out.println("***log 시작***");
		System.out.println(jp.getSignature().getName());
		System.out.println("***log 끝***");
	}
	
	 @AfterThrowing(pointcut="point2()",throwing="ex" )
	 public void log_ex(JoinPoint jp,Exception ex) {
	    	System.out.println("*** log_ex start. ****");
	    	System.out.print(jp.getSignature().getName());
	    	System.out.println("  위치에서  예외발생 :  "+ex);
	    	System.out.println("*** log_ex stop. ****");
	 }
}

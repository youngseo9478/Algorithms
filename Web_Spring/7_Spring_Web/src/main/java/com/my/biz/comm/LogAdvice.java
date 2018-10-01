package com.my.biz.comm;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.my.biz.user.vo.UserVO;

public class LogAdvice {	//Advice = 부가기능
	public void log(JoinPoint jp) {
		System.out.println("*** log start. ***");
		System.out.println(jp.getSignature().getName());
		Object[] obj = jp.getArgs();
		/*System.out.println("id : "+obj[0].toString());
		System.out.println("pw : "+obj[1].toString());*/
		for(Object data : obj) {
			System.out.print(data+", ");
		}
		System.out.println();
		System.out.println("*** log stop. ***");
	}
	
	public void log_ex(JoinPoint jp, Exception ex) {
		System.out.println("*** log_ex start. ***");
		System.out.println(jp.getSignature().getName() + "() 위치에서 예외 발생 : "+ex);
		System.out.println("*** log_ex stop. ***");
	}
	
	//public void log_return(Object obj) {
	public void log_return(JoinPoint jp, Object obj) {
		System.out.println("*** log_return start. ***");
		System.out.println(jp.getSignature().getName());
		System.out.println("리턴값 : " + obj);
		System.out.println("*** log_return stop. ***");
	}
	
	public void log_after() {
		System.out.println("*** log_after start. ***");
		System.out.println("*** log_after stop. ***");
	}
	
	//public void log_around() {	//가로채기
	public Object log_around(ProceedingJoinPoint pp) throws Throwable {	//가로채기
		System.out.println("*** log_around start. ***");
		Object obj = pp.proceed();
		// 리턴하기 전에 결과값 가공 가능한 위치
//		if (obj instanceof UserVO) {
//			((UserVO) obj).setPw("****");
//		}
		System.out.println("*** log_around stop. ***");
		return obj;
	}
}

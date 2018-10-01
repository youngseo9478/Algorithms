package com.my.biz.comm;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.my.biz.user.vo.UserVO;

public class LogAdvice { //Advice = 부가기능
	public void log(JoinPoint jp) {//JoinPoint
		System.out.println("***log 시작***");
		Object[] data =  jp.getArgs();
		System.out.println("id : "+data[0]);
		System.out.println("pw : "+data[1]);
		System.out.println("***log 끝***");
	}
	
	//생각지도않은 예외 발생했을 때 동작시키고 싶은 메소드
	public void log_ex(JoinPoint jp, Exception ex) { //조인포인트를 첫번째 매개변수로 넘겨줘야한다.
		System.out.println("***log_ex start***");
		System.out.println(jp.getSignature().getName()+"에서 예외발생 : "+ex);
		System.out.println("***log_ex stop***");
	}
	
	public void log_return(Object obj) { //예외발생했을때는 return전에 종료되기때문에 이 메소드는 수행 안한다
		System.out.println("***log_return start***");
		System.out.println("return : "+obj);
		System.out.println("***log_return stop***");
	}
	
	public void log_after() { //예외가 발생하든 안하든 수행되는 메소드
		System.out.println("***log_after start***");
		System.out.println("***log_after stop***");
	}
	public Object log_around(ProceedingJoinPoint pjp) throws Throwable{ //가로채기
		// AOP를 적용시키지 않았다면 바로 서비스와 연결되지만 AOP가 적용되어있다면 그 사이에 proxy가 대행을 하게 된다.
		// 그 중 aroud는 동작을 가로채버리기때문에 어떤 동작을 수행할지 말지를 결정할 수 있다.
		//가로챘으니까 어떤 동작을 수행할지 말지는 전적으로 around에 달렸다.
		//ProceedingJoinPoint pjp은 조인포인트의 자식으로 정보뿐만아니라 메소드를 수행할 능력도 다 가지고 있다.
		System.out.println("***log_around start***");
		Object obj = pjp.proceed();
		//리턴하기 전에 obj 값 가공 가능한 위치
		// if(obj instanceof UserVO) {
		// ((UserVO)obj).setPw("****");
		// }
		System.out.println("***log_around stop***");
		return obj;
	}
}

package spring.core.session05.aop_lab;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut(value = "execution(* spring.core.session05.aop_lab.Performance.perform(..))")
	public void pt() {}
	
	@Before(value = "pt()")
	public void close() {
		System.out.println("前置通知: 觀眾手機關靜音或關機...");
	}
	
	@Before(value = "pt()")
	public void takeSeats() {
		System.out.println("前置通知: 觀眾找座位...");
	}
	
	@After(value = "pt()")
	public void exit() {
		System.out.println("後置通知: 觀眾離場...");
	}
	
	@AfterReturning(value = "pt()")
	public void applause() {
		System.out.println("後置通知: 觀眾拍手鼓掌...");
	}
	
	@AfterThrowing(value = "pt()")
	public void shhhh() {
		System.out.println("後置通知: 觀眾 噓聲...");
	}
	
}

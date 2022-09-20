package spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session05.aop.MathCalc;

public class MathCalcAOPTest {
	@Test
	public void test() {
		// xml 配置
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		// Java 配置(Spring 4)
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		MathCalc calc = ctx.getBean("mathCalcImpl", MathCalc.class);
//		System.out.println("Test Class: " + calc.add(20, 10));
		System.out.println("Test Class: " + calc.div(20, 0));
	}
}

package spring.core.session01;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.conf.SpringConfig;
import spring.core.session01.beans.Lucky;

public class TestLucky {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringConfig.class);
		for(int i=0;i<10;i++) {			
			Lucky lucky = ctx.getBean(Lucky.class);
			System.out.println(lucky);
			Lucky lucky2 = ctx2.getBean(Lucky.class);
		}		
	}
}

package spring.core.session02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.material.Paper;
import spring.core.session02.beans.material.PaperRedB3;

public class TestPaper {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		by Type
//		Paper paper = ctx.getBean("paper", Paper.class);
//		System.out.println(paper);
		
		Paper paper2 = ctx.getBean("paper2", Paper.class);
		System.out.println(paper2);
		
		PaperRedB3 paperRedB3 = ctx.getBean("paper3", PaperRedB3.class);
		System.out.println(paperRedB3);
		
		Paper paper4 = ctx.getBean("paper4", Paper.class);
		System.out.println(paper4);
	}
}

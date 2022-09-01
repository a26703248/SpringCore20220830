package spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session01.beans.Lotto;



public class TestLotto {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Lotto lotto1 = ctx.getBean("lotto1", Lotto.class);
		Lotto lotto2 = ctx.getBean("lotto2", Lotto.class);
		System.out.println(lotto1);
		System.out.println(lotto2);
	}

}

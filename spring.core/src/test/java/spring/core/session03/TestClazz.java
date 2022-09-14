package spring.core.session03;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Clazz;

public class TestClazz {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Clazz clazz1 = ctx.getBean("clazz1", Clazz.class);
		Clazz clazz2 = ctx.getBean("clazz2", Clazz.class);
		Clazz clazz3 = ctx.getBean("clazz3", Clazz.class);
		System.out.println(clazz1);
		
		Clazz[] clazzs = {clazz1, clazz2, clazz3};
		Arrays.stream(clazzs).forEach(System.out::println);
	}

}

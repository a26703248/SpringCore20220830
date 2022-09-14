package spring.core.session03;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Car;

public class TestCarFacetory {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		對 CarFacetory 要了兩台車
		Car car1 = ctx.getBean("carFacetory", Car.class);
		Car car2 = ctx.getBean("carFacetory", Car.class);
		System.out.println(car1);
		System.out.println(car2);
	}

}

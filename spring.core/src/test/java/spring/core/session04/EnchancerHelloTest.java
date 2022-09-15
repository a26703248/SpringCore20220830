package spring.core.session04;

import static org.junit.Assert.*;

import org.junit.Test;

import spring.core.session04.dyn.cglib.EnchancerHello;
import spring.core.session04.dyn.cglib.Hello;


public class EnchancerHelloTest {

	@Test
	public void test() {
		Hello hello = new Hello();
		System.out.println(hello.sayHello("John"));
		
		Hello hello2 = new EnchancerHello();
		System.out.println(hello2.sayHello("Mary"));
		
	}

}

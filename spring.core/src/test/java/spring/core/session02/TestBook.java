package spring.core.session02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.Book;


public class TestBook {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book1 = ctx.getBean("book1", Book.class);
		System.out.println(book1);
		
		Book book2 = ctx.getBean("book2", Book.class);
		System.out.println(book2);
		
		Book book3 = ctx.getBean("book3", Book.class);
		System.out.println(book3);
		
		Book book4 = ctx.getBean("book4", Book.class);
		System.out.println(book4);
		
		Book book5 = ctx.getBean("book5", Book.class);
		System.out.println(book5);
		
		Book book6 = ctx.getBean("book6", Book.class);
		System.out.println(book6);
	}
}

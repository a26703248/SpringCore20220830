package spring.core.session07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session07.tx.controller.BookController;

public class TestOneBook {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		try {			
			bookController.buyOneBook(1, 1); // wid = 1, bid = 1
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

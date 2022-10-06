package spring.core.session07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session07.exception.InsufficientAmount;
import spring.core.session07.exception.InsufficientQuantity;
import spring.core.session07.tx.controller.BookController;

public class TestManyBooks {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		try {			
			bookController.buyManyBooks(1, 1, 1, 1);
		} catch (InsufficientAmount | InsufficientQuantity e) {
			System.out.println(e);
		}

	}
}

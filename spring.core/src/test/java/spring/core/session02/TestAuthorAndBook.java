package spring.core.session02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.javafaker.Book;

import spring.core.conf.SpringConfig;
import spring.core.session02.beans.Author;

public class TestAuthorAndBook {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		Author author = ctx.getBean(Author.class);
		Book book = ctx.getBean(Book.class);
		System.out.println(author);
		System.out.println(book);
	}

}

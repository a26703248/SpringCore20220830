package spring.core.session02;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session02.beans.Author;

public class TestAuthor {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = ctx.getBean("author1", Author.class);
		System.out.println(author1);
//		進行手動注入
		author1.setName("howard");
		author1.setAge(25);
		author1.setSex('M');
		System.out.println(author1);
		
		Author author2 = ctx.getBean("author2", Author.class);
//		author2 在配置當中已經有預設注入資料(利用方法注入)
		System.out.println(author2);
		
//		author3 在配置當中已經有預設注入資料(利用建構子注入)
		Author author3 = ctx.getBean("author3", Author.class);
		System.out.println(author3);
		
//		author4 在配置當中已經有預設注入資料(利用簡易方法p注入)
		Author author4 = ctx.getBean("author4", Author.class);
		System.out.println(author3);
		
//		author5 在配置當中已經有預設注入資料(利用簡易建構子c注入)
		Author author5 = ctx.getBean("author5", Author.class);
		System.out.println(author3);
	}
}

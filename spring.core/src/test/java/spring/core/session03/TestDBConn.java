package spring.core.session03;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.DBConn;

public class TestDBConn {

	@Test
	public void test() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConn dbConn = ctx.getBean("dbConn", DBConn.class);
		dbConn.find();
		dbConn.find();
		dbConn.find();
//		關閉 close() 方法在 ClassPathXmlApplicationContext 才有定義
//		普通情況下不需要關閉除非要關閉該項服務
		ctx.close();
	}
}

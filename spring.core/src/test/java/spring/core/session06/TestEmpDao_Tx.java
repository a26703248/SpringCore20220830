package spring.core.session06;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session06.template.EmpDao;

public class TestEmpDao_Tx {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int[] rowCount = empDao.addTwoTx("B03", 18, "B04", 19);
		if(rowCount != null) {
			System.out.println(Arrays.toString(rowCount));
		}
	}

}

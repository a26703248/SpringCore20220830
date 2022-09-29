package spring.core.session06;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.simpleflatmapper.jdbc.named.Word;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.conf.SpringJdbcConfig;
import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;
import spring.core.session06.template.EmpDao;

public class EmpDaoTest6_Add {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int rowCount1 = empDao.addEmpOne1("X03", 30);
		System.out.println(rowCount1);
		int rowCount2 = empDao.addEmpOne2("X04", 32);
		System.out.println(rowCount2);
	}

}

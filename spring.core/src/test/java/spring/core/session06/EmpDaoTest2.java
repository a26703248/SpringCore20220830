package spring.core.session06;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.conf.SpringJdbcConfig;
import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class EmpDaoTest2 {

	@Test
	public void test() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
//		List<Emp> emps = empDao.queryAll2();
		List<Emp> emps = empDao.queryAll3();
		
		Emp emp = emps.stream().filter(e -> e.getAge() > 20).findFirst().get();
		System.out.println(emp.getEname());
	}

}

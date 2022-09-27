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

public class EmpDaoTest3 {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Emp> emps = empDao.queryAll4();
		
		emps.forEach(e -> System.out.printf("name: %s, jobs: %s\n", e.getEname(), e.getJobs()));
		
	}

}

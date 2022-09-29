package spring.core.session06;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.conf.SpringJdbcConfig;
import spring.core.session06.entity.Emp;
import spring.core.session06.entity.Job;
import spring.core.session06.template.EmpDao;

public class EmpDaoTest4 {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Job> emps = empDao.queryJobs();
		emps.forEach(j -> System.out.printf("job name: %s emp name: %s\n",
				j.getJname(),
				j.getEmp().getEname() == null?"":j.getEmp().getEname()));
		
	}

}

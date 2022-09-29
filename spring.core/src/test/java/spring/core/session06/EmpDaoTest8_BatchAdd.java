package spring.core.session06;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.conf.SpringJdbcConfig;
import spring.core.session06.entity.Emp;
import spring.core.session06.template.EmpDao;

public class EmpDaoTest8_BatchAdd {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("Z01", 24));
		emps.add(new Emp("Z02", 25));
		emps.add(new Emp("Z03", 26));
		int[] rowCount = empDao.batchAdd2(emps);
		System.out.println(Arrays.toString(rowCount));
	}

}

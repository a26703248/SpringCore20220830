package spring.core.session06;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.conf.SpringJdbcConfig;
import spring.core.session06.template.EmpDao;

public class EmpDaoTest7_BatchAdd {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[]{"Y01", 20});
		rows.add(new Object[]{"Y02", 40});
		rows.add(new Object[]{"Y03", 21});
		int[] rowcount = empDao.batchAdd(rows);
		System.out.println(Arrays.toString(rowcount));
	}

}

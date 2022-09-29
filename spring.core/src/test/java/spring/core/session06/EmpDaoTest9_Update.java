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

public class EmpDaoTest9_Update {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
//		取得 eid = 10 的 Emp 物件
		Emp emp = empDao.getEmpById(10);
		if(emp == null) {
			System.out.println("無此員工");
			return;
		}
//		修改名字 = M01, 年齡 = 23
		emp.setEname("M01");
		emp.setAge(23);
		int rowCount = empDao.updateEnameAndAgebyEmp(emp);
//		int rowCount = empDao.updateEnameAndAgebyId(emp.getEid(), emp.getEname(), emp.getAge());
		System.out.println(rowCount);
	}

}

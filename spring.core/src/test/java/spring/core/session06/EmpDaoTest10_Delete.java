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

public class EmpDaoTest10_Delete {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		// 刪除 eid = 11 的紀錄
		int rowCount = empDao.deleteById(11);
		if(rowCount == 0) {
			System.out.println("刪除失敗無資料可供刪除");
		}else {
			System.out.println("刪除成功");
		}
		
	}

}

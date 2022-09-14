package spring.core.session03;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.core.session03.beans.Student;

public class TestStudent {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		Student[] students = { student1, student2 };
		Arrays.stream(students).forEach(System.out::println);
//		問題:學生們總共修了幾學分 
//		1. student1 學生修了幾學分
		int studentCredit1 = student1.getClazzs().stream().mapToInt(clz -> clz.getCredit()).sum();
		
		//		2. student2 學生修了幾學分
		int studentCredit2 = student2.getClazzs().stream().mapToInt(clz -> clz.getCredit()).sum();

		int total = Arrays.stream(students).flatMap(stu -> stu.getClazzs().stream()).mapToInt(clz -> clz.getCredit())
				.sum();

		System.out.println(total);
		
	}

}

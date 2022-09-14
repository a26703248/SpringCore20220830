package spring.core.session03;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Name;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import spring.core.session03.beans.Clazz;
import spring.core.session03.beans.Teacher;

public class TestTeacher {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher1 = ctx.getBean("teacher1", Teacher.class);
		System.out.println(teacher1);

//		請印出 teacher1 的學生名字與該學生的總學分各是多少
		teacher1.getStudents().stream().mapToInt(stu -> stu.getClazzs().stream().mapToInt(clz -> clz.getCredit()).sum())
				.forEach(System.out::println);

//		請印出 teacher2 所教授的課程名稱與學分數
		Teacher teacher2 = ctx.getBean("teacher2", Teacher.class);
		Clazz[] clazzs = { ctx.getBean("clazz1", Clazz.class), ctx.getBean("clazz2", Clazz.class),
				ctx.getBean("clazz3", Clazz.class) };

		teacher2.getSubject().forEach(name -> {
			Optional<Clazz> optClazz = Arrays.stream(clazzs).parallel() // 平行處理加快速度
					.filter(cla -> cla.getName().equals(name)).findFirst();
			System.out.printf("科目: %s 學分: %s\n", name, optClazz.isPresent() ? optClazz.get().getCredit() : null);
		});

//		循序(default)與平行(parallel)處理若同時在一個 Stream 串流中發生，則系統是使用 sequential 還是 parallel?
//		一個流只會有一種處理方式，以最後為標準

		System.out.println(Arrays.stream(clazzs)
//				.parallel() // 平行(parallel)
				.sequential()
				.filter(cla -> cla.getName().equals("Java"))
//				.sequential() // 循序(default)
				.parallel()
				.isParallel());
		


	}

}

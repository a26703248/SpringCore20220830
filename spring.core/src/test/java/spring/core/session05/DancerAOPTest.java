package spring.core.session05;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.session05.aop_lab.Performance;
import spring.core.session05.aop_lab.Singer;

public class DancerAOPTest {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {			
			dancer.perform(); // 舞者表演
		} catch (Exception e) {
//			舞者可以轉換跑道
//			改行當歌手
			System.out.println("舞者改行當歌手");
//			dancer 必須透過經理人 introducer -> singer
			Singer singer = (Singer) dancer;
			singer.sing();
		}
	}
}

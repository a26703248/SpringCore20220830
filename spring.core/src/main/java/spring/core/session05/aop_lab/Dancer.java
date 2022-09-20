package spring.core.session05.aop_lab;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Dancer implements Performance{

	@Override
	public void perform() {
		System.out.println("舞者表演開始");
		System.out.println("舞者動作: 轉圈, 翻滾 ...");
		Random random = new Random();
		if(random.nextInt(10)%3==0) {
			throw new RuntimeException("舞者跌倒");
		}
		System.out.println("舞者表演結束");
	}
}

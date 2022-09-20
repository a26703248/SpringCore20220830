package spring.core.session05.aop;

import org.springframework.stereotype.Component;

@Component
public class MathCalcImpl implements MathCalc{

	
	// 前置通執行時間點(方法執行前)
	@Override
	public Integer add(Integer x, Integer y) {
		Integer result = x + y;
//		System.out.println("回傳前");
		return result;
	}
	// 後置通執行時間點(方法回傳值)

	@Override
	public Integer div(Integer x, Integer y) {
		Integer result = x /y;
//		System.out.println("回傳前");
		return result;
	}
	
	@Override
	public void notReturn() {
		System.out.println("無回傳值");
		System.out.println("回傳前");
	}

}

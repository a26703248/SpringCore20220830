package spring.core.session04;

import static org.junit.Assert.*;

import org.junit.Test;

import spring.core.session04.dyn.jdk.Calc;
import spring.core.session04.dyn.jdk.CalcImpl;
import spring.core.session04.dyn.jdk.DynJDKProxy;
import spring.core.session04.sta.none.Person;
import spring.core.session04.sta.proxy.Woman;

public class DynJDKProxyTest {

	@Test
	public void test() {
//		未經過代理物件
		Calc calc = new CalcImpl();
		System.out.println("未經過代理物件: " + calc.add(10, 20));
		
//		經過 JDk 動態代理
		Calc calc2 = (Calc)new DynJDKProxy(new CalcImpl()).getProxy();
		calc2.add(10, 20);
		
//		Person person = (Person)new DynJDKProxy(new Woman()).getProxy();
//		person.work();
	}

}

package spring.core.session04;

import static org.junit.Assert.*;

import org.junit.Test;

import spring.core.session04.sta.proxy.Person;
import spring.core.session04.sta.proxy.Man;
import spring.core.session04.sta.proxy.PersonProxy;
import spring.core.session04.sta.proxy.Woman;

public class StaticProxyTest {

	@Test
	public void test() {
		// 透過代理模式來執行
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		
		man.work();
		woman.work();
		
	}

}

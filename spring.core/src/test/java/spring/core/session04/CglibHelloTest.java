package spring.core.session04;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import spring.core.session04.dyn.cglib.Hello;
import spring.core.session04.dyn.cglib.MyMethodIntercepter;

public class CglibHelloTest {

	@Test
	public void test() {
//		使用 cglib
//		1. 建立增強器
		Enhancer enhancer = new Enhancer();
//		2. 要增強對象
		enhancer.setSuperclass(Hello.class);
//		3. 設置方法攔截器(設定多攔截器會以最後為主)
		enhancer.setCallback(new MyMethodIntercepter());
		
		enhancer.setCallback(new testIn());
//		4. 運行
		Hello hello = (Hello)enhancer.create();
		System.out.println(hello.sayHello("John"));
		System.out.println(hello.info("mary"));
	}

}
class testIn implements MethodInterceptor{


	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("testIn:請出示實聯 QRcode");
		return proxy.invokeSuper(obj, args);
	}
	
}
